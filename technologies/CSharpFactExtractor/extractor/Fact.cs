using System;
using System.Collections.Generic;
using System.IO;
using ICSharpCode.NRefactory.CSharp;

namespace CSharpFactExtractor {
	class Declaration {
		private string name;
		private string classifier;
		private List<string> methods = new List<string>();
		private Dictionary<string, int> methodCnt = new Dictionary<string, int>();
		private SortedSet<String> attributes = new SortedSet<String>();
		
		public string Name
		{ 
			get { return name; }
		}
		
		public IEnumerable<String> Methods
		{
			get { return methods; }
		}
		
		public IEnumerable<String> Attributes
		{
			get { return attributes; }
		}
		
		private void extractAttributes(AstNodeCollection<AttributeSection> attributes) {
			if (attributes != null)
				foreach (ICSharpCode.NRefactory.CSharp.AttributeSection a in attributes) {
					foreach (ICSharpCode.NRefactory.CSharp.Attribute at in a.Attributes)
						if (!this.attributes.Contains(at.FirstChild.ToString())) {
							this.attributes.Add(at.FirstChild.ToString());
						}
				}
		}

		private void countMethods(string name) {
			if (methodCnt.ContainsKey(name))
				methodCnt[name]++;
			else
				methodCnt[name] = 0;	
		}
		
		public Declaration(TypeDeclaration typeDeclaration, string classifier) {
			name = typeDeclaration.Name;
			this.classifier = classifier;
			extractAttributes(typeDeclaration.Attributes);

			
			foreach (AstNode node in typeDeclaration.Children) {
				ConstructorDeclaration c = node as ConstructorDeclaration;
				if (c != null) {
					countMethods(c.Name);

					extractAttributes(c.Attributes);
					methods.Add(c.Name + methodCnt[c.Name]);
				}
				MethodDeclaration d = node as MethodDeclaration;
				if (d != null) {
					countMethods(d.Name);

					extractAttributes(d.Attributes);
					methods.Add(d.Name + methodCnt[d.Name]);
				}
				PropertyDeclaration p = node as PropertyDeclaration;
				if (p != null) {
					countMethods(p.Name);

					extractAttributes(p.Attributes);
					methods.Add(p.Name + methodCnt[p.Name]);
				}
				
 			}
		}
		
		public string asJson() {
			string json = "\t\t{\n";
			json += "\t\t\t\"name\" : \"" + name + "\",\n";
			json += "\t\t\t\"classifier\" : \"" + classifier + "\",\n";

			json += "\t\t\t\"fragments\" : [\n";
			//add methods
			//add method overloading
			List<string> methodsList = new List<string>(methods);
			for (int i = 0; i < methodsList.Count-1; i++) {
				json += "\t\t\t\t{\n";
				string methodName = methodsList[i].Substring(0, methodsList[i].Length-1);
				string index = methodsList[i].Substring(methodsList[i].Length-1);

				json += "\t\t\t\t\t\"name\" : \"" + methodName + "\",\n";
				if (index != "0")
					json += "\t\t\t\t\t\"index\" : \"" + index + "\",\n";

				//if (methodCnt[methodsList[i]] > 0)
				//	json += "\t\t\t\t\t\"index\" : \"" + methodCnt[methodsList[i]] + "\",\n";
				
				json += "\t\t\t\t\t\"classifier\" : \"" + "method" + "\"\n";
				json += "\t\t\t\t},\n";
			}

			if (methods.Count > 0) {
				json += "\t\t\t\t{\n";
				json += "\t\t\t\t\t\"name\" : \"" + methodsList[methods.Count-1] + "\",\n";
				json += "\t\t\t\t\t\"classifier\" : \"" + "method" + "\"\n";
				json += "\t\t\t\t}\n";
			}
			json += "\t\t\t]\n";
			
			/*json += "\t\t\t\"attributes\" : [\n";
			//add annotations
			List<string> attributesList = new List<string>(attributes);
			for (int i = 0; i < attributesList.Count-1; i++)
				json += "\t\t\t\t\"" + attributesList[i] + "\",\n";
			if (attributes.Count > 0)
				json += "\t\t\t\t\"" + attributesList[attributesList.Count-1] + "\"\n";
			json += "\t\t\t]\n";*/
			json += "\t\t}";
			
			return json;
		}
	}
	
	public class Fact : DepthFirstAstVisitor {
		private String comment = "";
		private String package = "";
		private int firstClassStartLine = -1;
//		private int nameSpaceStartLine = -1;
		private SortedSet<String> imports = new SortedSet<String>();
		private List<Declaration> declarations = new List<Declaration>();
		private List<Comment> comments = new List<Comment>();
		
		public Fact (TextReader input) {			

			CSharpParser parser = new CSharpParser();
			CompilationUnit unit = parser.Parse(input, "");
			
			this.VisitCompilationUnit(unit);
			
			for (int j = 0; j < comments.Count; j++)
				if (comments[j].StartLocation.Line< firstClassStartLine)
					comment += comments[j].GetText().Replace("//","").Replace("\n", "\\n");
		}
		
		
		
		public override void VisitNamespaceDeclaration (NamespaceDeclaration namespaceDeclaration)
		{
			package = namespaceDeclaration.Name;
			//nameSpaceStartLine = namespaceDeclaration.EndLocation.Line;
			base.VisitNamespaceDeclaration(namespaceDeclaration);
		}
		
		public override void VisitUsingDeclaration (UsingDeclaration usingDeclaration)
		{
			imports.Add(usingDeclaration.GetText().Replace("using ", "").Replace(";\n", ""));
			base.VisitUsingDeclaration (usingDeclaration);
		}
		
		public override void VisitComment (Comment comment)
		{
			comments.Add(comment);
			base.VisitComment(comment);
		}
		
		public override void VisitAttribute (ICSharpCode.NRefactory.CSharp.Attribute attribute)
		{
			base.VisitAttribute (attribute);
		}
		
		public override void VisitTypeDeclaration (TypeDeclaration typeDeclaration)
		{
			if (firstClassStartLine == -1)
					firstClassStartLine = typeDeclaration.StartLocation.Line;
			if (typeDeclaration.ClassType == ClassType.Class) {
				declarations.Add(new Declaration(typeDeclaration, "class"));
			} else if (typeDeclaration.ClassType == ClassType.Struct) {
				declarations.Add(new Declaration(typeDeclaration, "struct"));
			} else if (typeDeclaration.ClassType == ClassType.Interface) {
				declarations.Add(new Declaration(typeDeclaration, "interface"));
			} else if (typeDeclaration.ClassType == ClassType.Enum) {
				declarations.Add(new Declaration(typeDeclaration, "enum"));
			}
			base.VisitTypeDeclaration (typeDeclaration);
		}
		
		public string asJson() {
			string json = "{\n";
			//json += "\t\"comment\" : \"" + comment + "\",\n";
			json += "\t\"package\" : \"" + package + "\",\n";
			
			json += "\t\"imports\" : [\n";
			List<String> importList = new List<String>(imports);
			for (int i = 0; i < importList.Count-1; i++)
				json += "\t\t\""+importList[i]+"\",\n";
			if (importList.Count > 0)
				json += "\t\t\""+importList[importList.Count-1]+"\"\n";
			json += "\t],\n";
			
			json += "\t\"fragments\" : [\n";
			for (int i = 0; i < declarations.Count-1; i++)
				json += declarations[i].asJson() + ",\n";
			if (declarations.Count > 0)
				json += declarations[declarations.Count-1].asJson() + "\n";
			json += "\t]\n";
			json += "}";
			
			return json;
		}
	}
}