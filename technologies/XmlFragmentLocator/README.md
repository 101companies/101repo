# Headline

a fragment locator for XML

# Background

See http://101companies.org/index.php/Technology:XmlFragmentLocator

# Usage

The executable locator.py takes three arguments.

* inputFile is the name of an XML input input file.
* fragmentFile is the name of a .json input file with the fragment description.
* linesFile is the name of a .json output file with the determined line range.

# Building

The tool builds itself when needed.

# Testing

Run "make test" to test the tool.

(The test case is about the selection of a specific global element declaration
in a given schema.)

# Architecture

The locator is essentially coded in Java; see subdirectory locator/*.java.

The executable locator.py is only used for convenience of invocation.
