#! /usr/bin/env python
# heavily inspired by https://github.com/srackham/w3c-validator/blob/master/w3c-validator.py

import os
import sys
import json
import commands

def validateHTML(fileName):
	cmd = ('curl -sF "uploaded_file=@%s;type=text/html" -F output=json http://validator.w3.org/check' % (fileName))
	status, output = commands.getstatusoutput(cmd)
	w3cresult = json.loads(output)
	errors = 0
	warnings = 0	
	for msg in w3cresult['messages']:
		if msg.get('type') == 'error':
			if verbose:
				print 'error: ' + msg['message']
			errors += 1
		if msg.get('subtype') == 'warning':
			if verbose:
				print 'warning: ' + msg['message']
			warnings += 1
	return (errors, warnings)

def validateCSS(fileName):
	cmd = ('curl -sF "file=@%s;type=text/css" -F output=json http://jigsaw.w3.org/css-validator/validator' % (fileName))
	status, output = commands.getstatusoutput(cmd)
	w3cresult = json.loads(output)
	errors   = w3cresult['cssvalidation']['result']['errorcount']
	warnings = w3cresult['cssvalidation']['result']['warningcount']
	if verbose:
		print output
	return (errors, warnings)




if len(sys.argv) < 2:
	sys.exit('Usage: w3cValidator.py filename [-verbose]')

fileName = sys.argv[1]
verbose = False

if len(sys.argv) == 3:
	if sys.argv[2] == '-verbose':
		verbose = True

if fileName.endswith('.css'):
	(errorCount, warningCount) = validateCSS(fileName)										   #MML = MathML	
elif fileName.endswith('.html') or fileName.endswith('.xhtml') or fileName.endswith('.svg') or fileName.endswith('.mml'):
	(errorCount, warningCount) = validateHTML(fileName)
else:
	print "didn't recognize file - aborting..."
	sys.exit(1)	
	
if errorCount:
	print 'exiting with error, because validation failed with ' + str(errorCount) + ' error(s)'	
	sys.exit(1)
