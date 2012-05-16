generate:
	dmcs -target:exe -out:bin/locator.exe -lib:./bin -reference:Mono.Cecil.dll -reference:ICSharpCode.NRefactory.dll -reference:ICSharpCode.NRefactory.CSharp.dll -reference:ICSharpCode.NRefactory.Tests.dll -reference:ICSharpCode.NRefactory.Xml.dll ./locator/Main.cs ./locator/JSON.cs ./locator/LocatorCSharpParser.cs

test:
	mono bin/Locator.exe Company.cs fragment.json lines.json
	diff -w baseline.json lines.json	

clean:
	rm bin/locator.exe
	rm lines.json
