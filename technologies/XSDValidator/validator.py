#! /usr/bin/env python

import commands
import os.path
import sys

if len(sys.argv) != 2:
    sys.exit("Usage: validator.py inputFile")
command = "make run file=" + sys.argv[1]
status, output = commands.getstatusoutput(command)
print output
print status
sys.exit(status)
   
