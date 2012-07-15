build:
	make csharpfactextractor/CSharpFactExtractor.exe

csharpfactextractor/CSharpFactExtractor.exe: extractor/*.cs Makefile
	dmcs \
			-target:exe -out:bin/extractor.exe \
			-lib:./lib -reference:Mono.Cecil.dll -reference:ICSharpCode.NRefactory.dll -reference:ICSharpCode.NRefactory.CSharp.dll \
			-reference:ICSharpCode.NRefactory.Tests.dll -reference:ICSharpCode.NRefactory.Xml.dll \
			extractor/*.cs
	cp lib/*.dll bin
	cp lib/*.so bin

test:
	mono bin/extractor.exe Company.cs Company.cs.facts.json

clean:
	rm -r bin/*.exe
	rm -r bin/*.dll
	rm -r bin/*.so
	rm -f Company.cs.facts.json
