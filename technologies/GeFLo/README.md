# Headline

GeFLo is a generic fragment locator based on regular expressions.

# Background

See http://101companies.org/index.php/Technology:GeFLo

# Usage

The main class takes two arguments.

* **inputFile** is the name of a script input file.
* **gefloFile** is...
** ...either the name of a .geflo input file, which is encoded in UTF-8 and contains a GeFLo-pattern
** ...or a geflo pattern string.

The locator writes without respect to existing files to the path of the **gefloFile** by replacing the .geflo suffix through .baseline.

## Input file

The JSON-parser expects the following structure as an input :
  [
    {
      "text" : "import",
      "line" : 1,
      "i" : 0,
      "class" : "kw"    // not used in current implementation
    }
    ... other tokens
  ]  

## Example call

	# preferred:
	locator.py data/company.rb data/cut.geflo data/cut.lines
	
	# alternative:
	java -jar geflo.jar data/company.rb data/cut.geflo data/cut.lines

# Building

The tool can be builded by calling:

	# preferred:
	make Locator
	
	# alternative:
	mkdir bin
	javac \
		-nowarn \
		-encoding UTF-8 \
		-classpath src;libs/* \
		-d bin \
		src/geflo/main/*.java

# Testing

There is one class with several test cases for geflo pattern matching: "geflo.main.TestOnExampleScript".

Furthermore there are in the sub directory "data" some example files, which could be used to test the
command line interface. Therefore you can either use the Makefile or the main method of the class
"geflo.main.MainTester".

You can run the tests by calling:
	
	# full test:
	make test
	
	# jUnit-only:
	java -cp libs/junit-4.10.jar;src org.junit.runner.JUnitCore src/geflo/main/TestOnExampleScript.java
	
	# CLI-only:
	java -cp bin geflo.main.MainTester

# Architecture

The locator is essentially coded in Java; see package geflo.
For tokenize script files, there exists a php proxy to megalib, which is called "getGeSHiTokens.php".
It includes the megalib library, which itself uses GeSHi to tokenize scripts.

Tested with JavaSE-1.6.0_31.

Tested with jUnit 4.8.2.

# Project dependencies

* [**jUnit 4**](http://www.junit.org/) licensed under "Common Public License - v 1.0"
* [**JSON-java**](http://json.org/java/) by Douglas Crockford licensed under "The software shall be used for good, not evil."