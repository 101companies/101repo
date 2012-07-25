#! /usr/bin/env python

import commands
import os.path
import simplejson
import sys

if len(sys.argv) != 3:
	sys.exit("Usage: extractor.py inputFile outputFile");
locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "cd " + x + "; make"
status, output = commands.getstatusoutput(command)
if (status):
	print output
	sys.exit(status)
command = "cd " + x + "; mono bin/extractor.exe " + sys.argv[1] + " " + sys.argv[2]
status, output = commands.getstatusoutput(command)
if (status):
	print output
	sys.exit(status) 
