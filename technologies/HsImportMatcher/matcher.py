#! /usr/bin/env python

import commands
import os.path
import simplejson
import sys

# Check usage
if len(sys.argv) != 3:
    sys.exit("Usage: matcher.py inputFile namespace")

# Make sure matcher is fully built
locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "cd " + x + "; make"
status, output = commands.getstatusoutput(command)
if (status):
    sys.exit(output)

# Invoke matcher
command = x + "/Matcher " + sys.argv[1] + " " + sys.argv[2]
status, output = commands.getstatusoutput(command)
if (status):
    sys.exit(output)
