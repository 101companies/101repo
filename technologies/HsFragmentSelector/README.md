# Headline

a fragment locator for Haskell

# Background

See http://101companies.org/index.php/Technology:HsFragmentLocator

# Usage

The executable locator.py takes three arguments.

* inputFile is the name of a .hs input input file.
* fragmentFile is the name of a .json input file with the fragment description.
* linesFile is the name of a .json output file with the determined line range.

# Building

The tool builds itself when needed.

# Testing

Run "make test" to test the tool.

See tests for the files of the test cases.

See the Makefile for the execution of test cases.

# Architecture

The locator is essentially coded in Haskell; see *.hs.

The executable locator.py is only used for convenience of invocation.

Tested with Haskell Platform 2011.4.0.0 64 bit.

As part of it, tested with GHC version 7.0.4.

Additionally, the cabal package json is required. (Tested with json-0.4.4.)
