#!/usr/bin/env python

import commands
import os.path
import simplejson
import sys
import subprocess

locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "mono " + x + "/locator/bin/Debug/locator.exe {0}".format(sys.argv[1]) 
subprocess.call([command], shell=True)