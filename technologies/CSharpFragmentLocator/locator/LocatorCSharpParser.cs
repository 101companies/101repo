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
	
	public class LocatorCSharpParser : DepthFirstAstVisitor {
		private Dictionary<string, int> _methodCnt = new Dictionary<string, int>();
		private Dictionary<string, Tupel> _methodRanges = new Dictionary<string, Tupel>();
		private bool overload = false;
		
		
		public Tupel this[string method] {
			get {
				return _methodRanges[method];
			}
		}

		
		public LocatorCSharpParser (String filePath, bool overload) {
			this.overload = overload;
			
			TextReader reader = File.OpenText(filePath);
			CSharpParser parser = new CSharpParser();
			CompilationUnit compilationUnit = parser.Parse(reader, filePath);
			this.VisitCompilationUnit(compilationUnit);
		
			//Console.WriteLine("iterating over");
			//foreach (KeyValuePair<string, Tupel> entry in _methodRanges)
			//	Console.WriteLine(entry.Key + ": " + entry.Value.toJSON());
		}
		
		public override void VisitConstructorDeclaration (ConstructorDeclaration declaration) {
			Tupel t = new Tupel(declaration.StartLocation.Line, declaration.EndLocation.Line);
			addToMap(declaration.Name, t);
			//_methodRanges.Add(constructorDeclaration.Name, new Tupel(constructorDeclaration.StartLocation.Line,
			//                                                         constructorDeclaration.EndLocation.Line));
		}
		
		public override void VisitPropertyDeclaration (PropertyDeclaration declaration) {
			Tupel t = new Tupel(declaration.StartLocation.Line, declaration.EndLocation.Line);
			addToMap(declaration.Name, t);
		}
		
		public override void VisitMethodDeclaration (MethodDeclaration declaration) {
			Tupel t = new Tupel(declaration.StartLocation.Line, declaration.EndLocation.Line);
			addToMap(declaration.Name, t);
		}
		
		private void addToMap(string name, Tupel lineRange) {
			string methnodName = name;
			if (overload) {
				int cnt = 0;
				if (_methodCnt.ContainsKey(name))
					cnt = _methodCnt[name];
				methnodName += cnt;
				
				cnt++;
				_methodCnt[name] = cnt;
			}
			

			
			_methodRanges.Add(methnodName, lineRange);
		}
	}
	
}

