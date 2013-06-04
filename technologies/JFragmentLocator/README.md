# Headline

A fragment locator for Java

# Background

See http://101companies.org/wiki/Technology:JFragmentLocator

# Usage

The executable is "locator.py".

The "/"-based fragment selector is provided as a command-line argument.

The source code on which to apply fragment location is read from stdin. 

The determined line range of the fragment is written in JSON format to stdout.

The following fragment selectors are supported:

* class/n: declaration of a class with the given name n 
* method/n: declaration of a method with the given name n

Preceding comments of declarations are included into their line ranges.

# Building

Build the tool with "make build".

See the Makefile for details.

# Testing

Test the tool with "make test".

See the Makefile for details.

Fragment location is permformed on tests/Serialization.java.

The baselines for outputs are available as tests/*.baseline.

# Architecture

The fact extractor is coded in Java; see jfragmentlocator/*.java.

For parsing, the library javaparser 1.0.8 is used.

All dependencies are included in the fragment locator (see dir "lib").
