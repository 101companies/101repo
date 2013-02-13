using System;
using System.IO;
using System.Collections;

namespace CSharpFragmentLocator {
	class MainClass {
		public static void Main (string[] args)	{
			String inputFile    = args[0];
			String fragmentFile = args[1];
			Hashtable fragment = null;			
			
			if (args.Length == 3) {
				String jsonText = File.ReadAllText(fragmentFile);
				fragment = (Hashtable) Procurios.Public.JSON.JsonDecode(jsonText);
			} else {
				string[] split = fragmentFile.Split('/');
				fragment = new Hashtable();
				fragment.Add("method", split[0]);
				if (split.Length > 1)
					fragment.Add("overload", split[1]);
			}
			bool overload = fragment.ContainsKey("overload");
			LocatorCSharpParser locator = new LocatorCSharpParser(inputFile, overload);
			
			
			string methodName = (string)fragment["method"];
			if (overload)
				methodName += (string)fragment["overload"];
			if (args.Length > 2)
				writeOutput(args[2], locator[methodName].toJSON());
			else
				Console.WriteLine(locator[methodName].toJSON());
		}
		
		
		private static void writeOutput(string path, string content) {
			TextWriter writer = File.CreateText(path);
			writer.WriteLine(content);
			writer.Close();
		}
	}
	

}
