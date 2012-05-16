# Headline

a fragment locator for C#

# Background

See http://101companies.org/index.php/Technology:CSharpFragmentLocator

# Usage
The executable locator.exe takes three arguments.

* inputFile is the name of a C# source file
* fragmentFile is the name of a .json input file with the fragment description
* linesFile is the name of a .json output file with the determined line range

To use the locator.exe, the mono framework must be used. In order to run it, execute "mono bin/Locator.exe inputFile fragmentFile linesFile".

# Building

The locator.exe can be build by executing "make generate" or by using "xbuild locator/locator.sln".
If "make generate" is used, the locator.exe will be in the subdirectory bin.
If "xbuild locator/locator.sln" is used, the locator will be in the subdirectory locator/bin/Debug.

# Testing

Run "make test" to test the tool.

# Architecture

The locator is coded in C#. see subdirectory locator/*.cs

The libary NRefactory is used for parsing the C# files; see the *.dll files in the subdirectory bin.

The source code provided in JSON.cs is used for JSON processing; see locator/JSON.cs for the actual implementation and it's origin. 

The class for parsing is contained in LocatorCSharpParser.cs . It uses the Visitor-Pattern to visit all nodes of interest in the AST resulting from the parsing process. Nodes that are visited are constructors, properties and methods. 
