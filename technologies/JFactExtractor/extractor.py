#! /usr/bin/env python

import commands
import os.path
import simplejson
import sys

import fileinput
import subprocess

locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "java -classpath " + x + ":"+ x + "/lib/* " + "jfactextractor.JFactExtractor "
subprocess.call([command], shell=True)
