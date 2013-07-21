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

extractorPy = sys.argv[0]
x = os.path.dirname(extractorPy)
command = "mono " + x + "/bin/extractor.exe"
subprocess.call([command], shell=True)