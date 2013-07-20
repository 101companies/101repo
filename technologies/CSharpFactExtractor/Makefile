build:
	make csharpfactextractor/CSharpFactExtractor.exe

csharpfactextractor/CSharpFactExtractor.exe: extractor/*.cs Makefile
	mkdir -p bin
	dmcs \
			-target:exe -out:bin/extractor.exe \
			-lib:./lib -reference:Mono.Cecil.dll -reference:ICSharpCode.NRefactory.dll -reference:ICSharpCode.NRefactory.CSharp.dll \
			-reference:ICSharpCode.NRefactory.Tests.dll -reference:ICSharpCode.NRefactory.Xml.dll \
			extractor/*.cs
	cp lib/*.dll bin
	cp lib/*.so bin

test:
	./extractor.py < Company.cs > Company.cs.facts.json
	diff --ignore-all-space simple.baseline Company.cs.facts.json

clean:
	rm -rf bin/*.exe
	rm -rf bin/*.dll
	rm -rf bin/*.so
	rm -f Company.cs.facts.json
