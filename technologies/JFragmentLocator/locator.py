#! /usr/bin/env python

import commands
import os.path
import simplejson
import sys

if len(sys.argv) != 3 and len(sys.argv) != 4:
    sys.exit("Usage: locator.py inputFile fragmentFile linesFile\nUsage (alternative): locator.py inputFile fragmentDescription")
locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "cd " + x + "; make"
status, output = commands.getstatusoutput(command)
if (status):
    print output
    sys.exit(status)
command = "java -classpath " + x + ":"+ x + "/lib/* " + "locator/JFragmentLocator " + sys.argv[1] + " " + sys.argv[2]
if len(sys.argv) == 4:
    command += " " + sys.argv[3]
status, output = commands.getstatusoutput(command)
if (status):
    print output
    sys.exit(status)

print output
