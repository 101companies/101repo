#! /usr/bin/env python

import commands
import os.path
import simplejson
import sys

if len(sys.argv) != 3:
    sys.exit("Usage: extractor.py inputFile factsFile")
locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "cd " + x + "; make"
status, output = commands.getstatusoutput(command)
if (status):
    print output
    sys.exit(status)
command = "java -classpath " + x + ":"+ x + "/lib/* " + "jfactextractor.JFactExtractor " + sys.argv[1] + " " + sys.argv[2]
status, output = commands.getstatusoutput(command)
if (status):
    print output
    sys.exit(status)
