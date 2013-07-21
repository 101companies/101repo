using System;
using System.IO;
using System.Collections;

namespace CSharpFragmentLocator {
	class MainClass {
		public static void Main (string[] args)	{
			//String inputFile    = args[0];
			//String fragmentFile = args[1];
			//Hashtable fragment = null;			
			
			//if (args.Length == 3) {
			//	String jsonText = File.ReadAllText(fragmentFile);
			//	fragment = (Hashtable) Procurios.Public.JSON.JsonDecode(jsonText);
			//} else {
			//	string[] split = fragmentFile.Split('/');
			//	fragment = new Hashtable();
			//	fragment.Add("method", split[0]);
			//	if (split.Length > 1)
			//		fragment.Add("overload", split[1]);
			//}
			//bool overload = fragment.ContainsKey("overload");
			string[] queryParts = args[0].Split('/');
			LocatorCSharpParser locator = new LocatorCSharpParser(Console.In);

			string classifier = queryParts[0];
			string name = queryParts[1];
			TypeDeclDict decls = null;

			if (classifier == "class") {
				decls = locator.getClassDefinitions(name);
			} else if (classifier == "struct") {
				decls = locator.getStructDefinitions(name);
			} else if (classifier == "interface") {
				decls = locator.getInterfaceDefinitions(name);
			} else if (classifier == "enum") {
				decls = locator.getEnumDefinitions(name);
			}

			if (queryParts.Length == 2) {
				Console.WriteLine(decls.TypeDeclTupel.toJSON());
			} else {
				classifier = queryParts[2];
				name = queryParts[3];
				if (queryParts.Length > 4)
					name += queryParts[4];
				else
					name += "0";

				Console.WriteLine(decls[name].toJSON());
			}
			
			
		}

	}
	

}
