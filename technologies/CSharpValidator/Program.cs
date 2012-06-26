using System;
using System.IO;
using ICSharpCode.NRefactory.CSharp;

namespace acceptCsharp
{
	public class CsParser
	{
		public static void Main(string[] args)
		{
			Console.WriteLine("(C) 2011 acceptCsharp @ softlang in Koblenz");
			if(args.Length < 1)
			{
				Console.WriteLine("Usage: acceptCsharp file.cs");
				Environment.Exit(-1);
			}
			var parser = new CSharpParser();
			var fileName = args[0];
			CompilationUnit cu = null;
			try
			{
				using (var fs = new FileStream(fileName, FileMode.Open))
				{
					cu = parser.Parse(fs);
				}
			}
			catch (DirectoryNotFoundException ex)
			{
				Console.WriteLine(ex.Message);
				Environment.Exit(-1);
			}
			catch (FileNotFoundException ex)
			{
				Console.WriteLine(ex.Message);
				Environment.Exit(-1);
			}

			if (cu.Errors.Count > 0)
			{
				Console.WriteLine(string.Format("-> {0} is not a valid C# file.", fileName));
				Console.WriteLine("-> Validation failed.");
				Environment.Exit(-1);
			}
			else
			{
				Console.WriteLine("-> Validation succeeded.");
			}

			Environment.Exit(0);
		}
	}
}
