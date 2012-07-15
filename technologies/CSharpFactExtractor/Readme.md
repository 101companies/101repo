# Headline
a fact extractor for C#

#Background
See http://101companies.org/index.php/Technology:CSharpFactExtractor

#Usage
The fact extractor can be used with the python script "extractor.py". It takes two arguments - one is the input file, which is a C# source code file. The other file is the output file, in which the result will be written (as a json file). 

To use it, execute "extractor.py inputFile outputFile".

NOTE: Since the fact extractor is written in C#, the mono environment must be installed.

#Building
The extractor.exe, which is used by the python script, can be build by executing "make build". The extractor.exe will be in the subdirectory bin.

#Testing
Run "make test" to test the tool.

#Architecture
The extractor is coded in C#; see subdirectory extractor/*.cs

The library NRefactory is used for parsing the C# files; see the *.dll and *.so files in the subdirectory lib.

The class in which parsing is actually done is Fact.cs. It uses the Visitor-Pattern to find all interesting nodes in the AST. If a TypeDeclaration node, which declares a class, is found this node and all of it's children are traversed to find all constructors, properties and methods.
