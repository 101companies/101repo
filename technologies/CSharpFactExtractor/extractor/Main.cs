using System;
using System.IO;

namespace CSharpFactExtractor {
	class MainClass	{
		public static void Main (string[] args) {
			//string line;
			//string programCode = "";
			//while ((line = Console.ReadLine()) != null) {
			//     programCode += Console.In.ReadLine();
			//}

			Fact fact = new Fact(Console.In);//Fact(programCode);
			Console.WriteLine(fact.asJson());
		}
	}
}
