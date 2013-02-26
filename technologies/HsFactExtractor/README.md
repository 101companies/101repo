# Headline

A fact extractor for Haskell

# Background

See http://101companies.org/wiki/Technology:HsFactExtractor

# Usage

The executable is "HsFactExtractor".

The source code for fact extraction is read from stdin.

The extracted JSON facts are written to stdout.

# Building

Build the tool with "make build".

See the Makefile for details.

# Testing

Test the tool with "make test".

See the Makefile for details.

See tests/Test.hs for an illustrative example.

The extracted facts are available as tests/Test.baseline.

# Architecture

The fact extractor is coded in Haskell; see *.hs.

Tested with Haskell Platform 2011.4.0.0 64 bit.

As part of it, tested with GHC version 7.0.4.

Additionally, the cabal package json is required. (Tested with json-0.4.4.)
