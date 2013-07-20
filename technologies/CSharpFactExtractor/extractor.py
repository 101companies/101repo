#! /usr/bin/env python

#import commands
#import os.path
#import simplejson
#import sys


import commands
import os.path
import simplejson
import sys

import fileinput
import subprocess

locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
#command = "java -classpath " + x + ":"+ x + "/lib/* " + "jfactextractor.JFactExtractor "
command = "mono " + x + "/bin/extractor.exe"
subprocess.call([command], shell=True)

#if len(sys.argv) != 3:
#	sys.exit("Usage: extractor.py inputFile outputFile");
#locatorPy = sys.argv[0]
#x = os.path.dirname(locatorPy)
#command = "cd " + x + "; make"
#status, output = commands.getstatusoutput(command)
#if (status):
#	print output
#	sys.exit(status)
#command = "mono " + x + "/bin/extractor.exe " + sys.argv[1] + " " + sys.argv[2]
#status, output = commands.getstatusoutput(command)
#if (status):
#	print output
#	sys.exit(status)
