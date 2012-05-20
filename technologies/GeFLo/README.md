# Headline

GeFLo is a generic fragment locator based on regular expressions.

# Background

See http://101companies.org/index.php/Technology:GeFLo

# Usage

The main class takes two arguments.

* **gefloFile** is the name of a .geflo input, which is encoded in UTF-8 and contains a GeFLo-pattern.
* **inputFile** is the name of a .summary.json input file.

The locator writes without respect to existing files to the path of the **gefloFile** by replacing the .geflo suffix through .baseline.

## Input file

The JSON-parser expects the following structure for .summary.json input file:
	{
		...,
		tokens: [
			...,
			{
				name: "token",
				line: 42,
				...,
			}
		],
	}

## Example call

	java -jar geflo.jar data/cut.geflo data/company.rb.summary.json

# Building

The tool can be builded by calling:

	javac -classpath src -encoding UTF-8 src/geflo/main/Main.java

# Testing

There is one class with several test cases: "geflo.main.TestOnExampleScript"

You can run it by calling:
	
	java -cp libs/junit-4.10.jar;src org.junit.runner.JUnitCore src/geflo/main/TestOnExampleScript.java

# Architecture

The locator is essentially coded in Java; see package geflo.

Tested with JavaSE-1.6.0_31.

Tested with jUnit 4.8.2.

# Project dependencies

* [**jUnit 4**](http://www.junit.org/) licensed under "Common Public License - v 1.0"
* [**JSON-java**](http://json.org/java/) by Douglas Crockford licensed under "The software shall be used for good, not evil."