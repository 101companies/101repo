# Headline

an import matcher for Haskell

# Background

See http://101companies.org/index.php/Technology:HsImportMatcher

# Usage

The executable matcher.py takes two arguments.

* inputFile is the name of a .hs input input file.
* namespace is the "." separated namespace (module name) of interest.

Normal exit means that matching succeeded.
Abnormal exit could mean that matching failed (or some other problem occurred).

# Building

The tool builds itself when needed.

# Testing

Run "make test" to test the tool.

The test case establishes that "Technology:HXT" (say namespace Text.XML.HXT) is used in 101implementation:hx.

# Architecture

The matcher is essentially coded in Haskell; see *.hs.

The executable matcher.py is only used for convenience of invocation.

Tested with GHC version 7.0.4.
