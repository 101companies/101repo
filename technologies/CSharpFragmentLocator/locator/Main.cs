using System;
using System.IO;
using System.Collections;

namespace CSharpFragmentLocator {
	class MainClass {
		public static void Main (string[] args)	{
			String inputFile    = args[0];
			String fragmentFile = args[1];
			String outputFile   = args[2];
			
			String jsonText = File.ReadAllText(fragmentFile);
			Hashtable fragment = (Hashtable) Procurios.Public.JSON.JsonDecode(jsonText);
			bool overload = fragment.ContainsKey("overload");
			
			
			LocatorCSharpParser locator = new LocatorCSharpParser(inputFile, overload);
			
			
			string methodName = (string)fragment["method"];
			if (overload)
				methodName += (string)fragment["overload"];
			
			writeOutput(outputFile, locator[methodName].toJSON());
		}
		
		
		private static void writeOutput(string path, string content) {
			TextWriter writer = File.CreateText(path);
			writer.WriteLine(content);
			writer.Close();
		}
	}
	

}
