#! /usr/bin/env python

import commands
import os.path
import simplejson
import sys

if len(sys.argv) != 4:
    sys.exit("Usage: locator.py inputFile gefloInput linesFile")
locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "cd " + x + "; make"
status, output = commands.getstatusoutput(command)
if (status):
    print output
    sys.exit(status)
command = "java -cp " + x + "/bin" + ":"+ x + "/libs/* " + "geflo.main.GeFLoFragmentLocator " + sys.argv[1] + " " + sys.argv[2] + " " + sys.argv[3]
status, output = commands.getstatusoutput(command)
if (status):
    print output
    sys.exit(status)
