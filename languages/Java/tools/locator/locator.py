#! /usr/bin/env python

import sys
import simplejson

if len(sys.argv) != 4:
    sys.exit("Usage: locator.py inputFile fragmentFile linesFile")
print sys.argv
inputFile = open(sys.argv[1], 'r')
fragmentFile = open(sys.argv[2], 'r')
linesFile = open(sys.argv[3], 'w')
linesFile.write(simplejson.dumps({'from': 1, 'to': 1}))
