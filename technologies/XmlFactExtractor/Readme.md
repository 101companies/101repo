# Headline

A fact extractor for XML

# Background

See http://101companies.org/wiki/Technology:XmlFactExtractor

# Usage

The executable is "extractor.py".

The source code for fact extraction is read from stdin.

The extracted JSON facts are written to stdout.

# Building

Building is not necessary

# Testing

Test the tool with "make test".

See the Makefile for details.


# Architecture

The fact extractor is coded in Python. 

It uses the Sax Library, that is included in Python, for parsing the XML code.
