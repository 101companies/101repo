#! /usr/bin/env python

import commands
import os.path
import simplejson
import sys
import subprocess

locatorPy = sys.argv[0]
x = os.path.dirname(locatorPy)
command = "java -classpath " + x + ":"+ x + "/lib/* " + "jfragmentlocator/JFragmentLocator " + sys.argv[1]
subprocess.call([command], shell=True)
