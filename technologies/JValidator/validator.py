#! /usr/bin/env python

import commands
import os.path
import simplejson
import sys

if len(sys.argv) != 2:
    sys.exit("Usage: validator.py inputFile")
locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "cd " + x + "; make"
status, output = commands.getstatusoutput(command)
if (status):
    print output
    sys.exit(status)
command = "java -classpath " + x + ":"+ x + "/lib/* " + "jvalidator.JValidator " + sys.argv[1]
status, output = commands.getstatusoutput(command)
if (status):
    print output
    sys.exit(status)
