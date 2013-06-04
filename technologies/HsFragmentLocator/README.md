# Headline

A fragment locator for Haskell

# Background

See http://101companies.org/wiki/Technology:HsFragmentLocator

# Usage

The executable is "HsFragmentLocator".

The "/"-based fragment selector is provided as a command-line argument.

The source code on which to apply fragment location is read from stdin. 

The determined line range of the fragment is written in JSON format to stdout.

The following fragment selectors are supported:

* type/n: declaration of a type synonym with the given name n 
* data/n: declaration of an algebraic data type with the given name n
* newtype/n: declaration of a newtype with the given name n
* function/n: declaration of a function with the given name n
* pattern/n: a pattern binding with the given name n

Preceding comments of declarations are included into their line ranges.

# Building

Build the tool with "make build".

See the Makefile for details.

# Testing

Test the tool with "make test".

See the Makefile for details.

Fragment location is permformed on tests/Test.hs.

The baselines for outputs are available as tests/*.baseline.

# Architecture

The fact extractor is coded in Haskell; see *.hs.

Tested with Haskell Platform 2011.4.0.0 64 bit.

As part of it, tested with GHC version 7.0.4.

Additionally, the cabal package json is required. (Tested with json-0.4.4.)
