using System;
using System.Collections.Generic;
using System.IO;
using ICSharpCode.NRefactory.CSharp;

namespace CSharpFragmentLocator {
	public struct Tupel {
		public int start;
		public int end;
		
		public Tupel(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public String toJSON() {
			return "{" + "\"from\":" + start + ",\"to\":"+end+"}";	
		}
	}
	
	public class TypeDeclDict {
		private Dictionary<string, int> _methodCnt = new Dictionary<string, int>();
		private Dictionary<string, Tupel> _methodRanges = new Dictionary<string, Tupel>();
		private bool overload = true;

		public Tupel TypeDeclTupel {
			get; private set;
		}

		public Tupel this[string method] {
			get {
				return _methodRanges[method];
			}
		}

		public TypeDeclDict(Tupel tuple) {
			this.TypeDeclTupel = tuple;
		} 

		public void addToMap(string name, Tupel lineRange) {
			string methodName = name;
			if (overload) {
				int cnt = 0;
				if (_methodCnt.ContainsKey(name))
					cnt = _methodCnt[name];
				methodName += cnt;
				
				cnt++;
				_methodCnt[name] = cnt;
			}
			
			_methodRanges.Add(methodName, lineRange);
		}

		public void debug() {
			Console.WriteLine("iterating over");
			foreach (KeyValuePair<string, Tupel> entry in _methodRanges)
				Console.WriteLine(entry.Key + ": " + entry.Value.toJSON());
		}
	}

	public class LocatorCSharpParser : DepthFirstAstVisitor {
		private Dictionary<string, TypeDeclDict> _classes = new Dictionary<string, TypeDeclDict>();
		private Dictionary<string, TypeDeclDict> _structs = new Dictionary<string, TypeDeclDict>();
		private Dictionary<string, TypeDeclDict> _interfaces = new Dictionary<string, TypeDeclDict>();
		private Dictionary<string, TypeDeclDict> _enums = new Dictionary<string, TypeDeclDict>();

		private TypeDeclDict _current;


		public LocatorCSharpParser (TextReader input) {
			CSharpParser parser = new CSharpParser();
			CompilationUnit compilationUnit = parser.Parse(input, "");
			this.VisitCompilationUnit(compilationUnit);
		
			/*foreach (KeyValuePair<string, TypeDeclDict> entry in _classes) {
				Console.WriteLine("talking about " + entry.Key);
				entry.Value.debug();
			}*/
		}

		public TypeDeclDict getClassDefinitions(string className) {
			return this._classes[className];
		}

		public TypeDeclDict getStructDefinitions(string structName) {
			return this._structs[structName];
		}

		public TypeDeclDict getInterfaceDefinitions(string interfaceName) {
			return this._interfaces[interfaceName];
		}

		public TypeDeclDict getEnumDefinitions(string enumName) {
			return this._enums[enumName];
		}

		public override void VisitTypeDeclaration (TypeDeclaration typeDeclaration)
		{
			_current = new TypeDeclDict(new Tupel(typeDeclaration.StartLocation.Line, typeDeclaration.EndLocation.Line));
			if (typeDeclaration.ClassType == ClassType.Class) {
				_classes.Add(typeDeclaration.Name, _current);
			} else if (typeDeclaration.ClassType == ClassType.Struct) {
				_structs.Add(typeDeclaration.Name, _current);
			} else if (typeDeclaration.ClassType == ClassType.Interface) {
				_interfaces.Add(typeDeclaration.Name, _current);
			} else if (typeDeclaration.ClassType == ClassType.Enum) {
				_enums.Add(typeDeclaration.Name, _current);
			}

			base.VisitTypeDeclaration (typeDeclaration);
		}
		
		public override void VisitConstructorDeclaration (ConstructorDeclaration declaration) {
			Tupel t = new Tupel(declaration.StartLocation.Line, declaration.EndLocation.Line);
			_current.addToMap(declaration.Name, t);
		}
		
		public override void VisitPropertyDeclaration (PropertyDeclaration declaration) {
			Tupel t = new Tupel(declaration.StartLocation.Line, declaration.EndLocation.Line);
			_current.addToMap(declaration.Name, t);
		}
		
		public override void VisitMethodDeclaration (MethodDeclaration declaration) {
			Tupel t = new Tupel(declaration.StartLocation.Line, declaration.EndLocation.Line);
			_current.addToMap(declaration.Name, t);
		}
		
	}
	
}

