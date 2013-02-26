# Headline

A fact extractor for Java

# Background

See http://101companies.org/wiki/Technology:JFactExtractor

# Usage

The executable is "extractor.py".

The source code for fact extraction is read from stdin.

The extracted JSON facts are written to stdout.

# Building

Build the tool with "make build".

See the Makefile for details.

# Testing

Test the tool with "make test".

See the Makefile for details.

See example/Serialization.java is used as input.

The extracted facts are available as example/baseline.json.

# Architecture

The fact extractor is coded in Java. 

It uses Gson 1.7.1 and Javaparser 1.0.8.

All dependencies are shipped with the Fact Extractor.
