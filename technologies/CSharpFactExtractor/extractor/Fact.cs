using System;
using System.Collections.Generic;
using System.IO;
using ICSharpCode.NRefactory.CSharp;

namespace CSharpFactExtractor {
	class Declaration {
		private String className;
		private SortedSet<String> methods = new SortedSet<String>();
		private SortedSet<String> attributes = new SortedSet<String>();
		
		public string ClassName
		{ 
			get { return className; }
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
		
		public Declaration(TypeDeclaration typeDeclaration) {
			className = typeDeclaration.Name;
			extractAttributes(typeDeclaration.Attributes);

			
			foreach (AstNode node in typeDeclaration.Children) {
				ConstructorDeclaration c = node as ConstructorDeclaration;
				if (c != null) {
					extractAttributes(c.Attributes);
					methods.Add(c.Name);
				}
				MethodDeclaration d = node as MethodDeclaration;
				if (d != null) {
					extractAttributes(d.Attributes);
					methods.Add(d.Name);
				}
				PropertyDeclaration p = node as PropertyDeclaration;
				if (p != null) {
					extractAttributes(p.Attributes);
					methods.Add(p.Name);
				}
				
 			}
		}
		
		public string asJson() {
			string json = "\t\t{\n";
			json += "\t\t\t\"name\" : \"" + className + "\",\n";
			json += "\t\t\t\"classifier\" : \"" + "class" + "\",\n";

			json += "\t\t\t\"fragments\" : [\n";
			//add methods
			List<string> methodsList = new List<string>(methods);
			for (int i = 0; i < methodsList.Count-1; i++) {
				json += "\t\t\t\t{\n";
				json += "\t\t\t\t\t\"name\" : \"" + methodsList[i] + "\",\n";
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
			if (typeDeclaration.ClassType == ClassType.Class) {
				if (firstClassStartLine == -1)
					firstClassStartLine = typeDeclaration.StartLocation.Line;
				declarations.Add(new Declaration(typeDeclaration));
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