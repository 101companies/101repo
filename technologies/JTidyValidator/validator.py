#! /usr/bin/env python

import os
import sys
import commands

if len(sys.argv) < 2:
	sys.exit('Usage: validator.py filename [-verbose] [-negative]')


validatorPy = sys.argv[0]
x = os.path.dirname(validatorPy)
filename = sys.argv[1]
verbose = False
negative = False

#checking command line arguments
for arg in sys.argv:
	if arg == '-verbose':
		verbose = True
	elif arg == '-negative':
		negative = True

#executing the command and getting output
cmd = 'java -jar ' + x + '/jtidy-r938.jar -q -e -n ' + filename
status, output = commands.getstatusoutput(cmd)
lines = output.splitlines()

errors = []
warnings = []

for s in lines:
	if s.find('Fehler') != -1:
		errors.append(s)
	else:
		warnings.append(s)

if verbose and warnings:
	print warnings

if errors:
	print errors
	if negative:
		print 'validation failed as expected'
		sys.exit(0)
	else:
		print 'validation failed'
		sys.exit(1)
else:
	if negative:
		print "validation succeeded, but it shouldn't"
		sys.exit(1)
	else:
		sys.exit(0)

#if errors > 0:
#	if negative:
#		print 'validation failed with ' + str(errors) + ' error(s) as expected'
#		sys.exit(0)
#	else:
#		print 'validation failed with ' + str(errors) + ' error(s)'
#		sys.exit(1)
#else:
#	if negative:
#		print "validation succeeded, but it shouldn't"
#		sys.exit(1)
#	else:
#		print 'validation succeeded'
#		sys.exit(0)
