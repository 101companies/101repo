#! /usr/bin/env python

import commands
import os.path
import simplejson
import sys

if len(sys.argv) != 4:
    sys.exit("Usage: locator.py inputFile fragmentFile linesFile")
locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "cd " + x + "; make"
status, output = commands.getstatusoutput(command)
if status:
    print "Status: " + str(status)
    print "Output: " + output
    sys.exit(status)
command = x + "/Locator " + sys.argv[1] + " " + sys.argv[2] + " " + sys.argv[3]
status, output = commands.getstatusoutput(command)
if status:
    print "Status: " + str(status)
    print "Output: " + output
    sys.exit(status)

