#! /usr/bin/env python

import json
import os
import sys
sys.path.append('../../libraries/101meta')
import const101

def search(fragment, classifier, name):
	if fragment['classifier'] == classifier and name in fragment['name'].lower():
		return True
	for f in fragment.get('fragments', []):
		if search(f, classifier, name):
			return True
	
	return False

classifier = sys.argv[1]
name = sys.argv[2]

extractorExt = '.extractor.json'
toReplace = '../../../101results/101repo/'

fileName = sys.argv[len(sys.argv)-1].replace(toReplace, '') + extractorExt
filePath = os.path.join(const101.tRoot, fileName)
if not os.path.exists(filePath):
	sys.exit(1)
extracted = json.load(open(filePath, 'r'))

for fragment in extracted['fragments']:
	if search(fragment, classifier, name):
		sys.exit()


sys.exit(1)
