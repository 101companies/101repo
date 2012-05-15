# Headline

a fragment locator for Java

# Background

See http://101companies.org/index.php/Technology:JFragmentLocator

# Usage

The executable locator.py takes three arguments.

* inputFile is the name of a .java input input file.
* fragmentFile is the name of a .json input file with the fragment description.
* linesFile is the name of a .json output file with the determined line range.

# Building

The tool builds itself when needed.

# Testing

Run "make test" to test the tool.

# Architecture

The locator is essentially coded in Java; see subdirectory locator/*.java.

The executable locator.py is only used for convenience of invocation.

The library javaparser is used for Java parsing; see subdirectory lib.

The library GSON is used for JSON processing; see subdirectory lib.
