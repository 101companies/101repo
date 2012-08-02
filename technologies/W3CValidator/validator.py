#! /usr/bin/env python
# heavily inspired by https://github.com/srackham/w3c-validator/blob/master/w3c-validator.py

import os
import sys
import json
import commands
import time

def validateHTML(fileName):
	cmd = ('curl -m 10 -sF "uploaded_file=@' + fileName + ';type=text/html" -F output=json http://validator.w3.org/check')
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

def validateCSS(fileName, x):
	cmd = 'java -jar ' + x + '/css-validator.jar --output=json file:' + fileName
	status, output = commands.getstatusoutput(cmd)
#	print output
	output = output.replace('{vextwarning=false, output=json, lang=en, warning=2, medium=all, profile=css3}', '')
	w3cresult = json.loads(output)
	errors   = w3cresult['cssvalidation']['result']['errorcount']
	warnings = w3cresult['cssvalidation']['result']['warningcount']
	#if verbose:
	#	print output
	return (errors, warnings)



if len(sys.argv) < 2:
	sys.exit('Usage: w3cValidator.py filename [-silent] [-negative]')

validatorPy = sys.argv[0]
x = os.path.dirname(validatorPy)

fileName = sys.argv[1]
verbose = True
negative = False

for arg in sys.argv:
	if arg == '-silent':
		verbose = False
	elif arg == '-negative':
		negative = True

if verbose:
	print 'checking ' + fileName

#try:
	if fileName.endswith('.css'):
		(errorCount, warningCount) = validateCSS(fileName, x)														   #MML = MathML	
	elif fileName.endswith('.html') or fileName.endswith('.xhtml') or fileName.endswith('.svg') or fileName.endswith('.mml'):
		(errorCount, warningCount) = validateHTML(fileName)
	else:
		print "didn't recognize file - aborting..."
		sys.exit(1)	
#except ValueError:
#	print "Something went wrong - answer wasn't a JSON object"
#	sys.exit(1)

if not negative:
	if errorCount:
		if verbose:
			print 'validation failed with ' + str(errorCount) + ' error(s)'
		sys.exit(1)
	else:
		if verbose:
			print 'validation succeeded'
		sys.exit(0)

if negative:
	if errorCount:
		if verbose:
			print 'validation failed with ' + str(errorCount) + ' error(s) as expected'	
		sys.exit(0)
	else:
		if verbose:
			print "validation succeeded, even though it shouldn't"
		sys.exit(1)
