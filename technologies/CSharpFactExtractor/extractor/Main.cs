using System;
using System.IO;

namespace CSharpFactExtractor {
	class MainClass	{
		public static void Main (string[] args) {
			if (args.Length != 2) {
				Console.WriteLine("2 Parameters expected - inputFile and outputFile");
				Environment.Exit(1);
			}
			string inputFile = args[0];
			string outputFile = args[1];
			
			Fact fact = new Fact(inputFile);
			TextWriter writer = File.CreateText(outputFile);
			writer.Write(fact.asJson());
			writer.Close();
		}
	}
}
