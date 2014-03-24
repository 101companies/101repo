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


def run(args=None, filePath=None):

    classifier = args[0]
    name = args[1]

    extractorExt = '.extractor.json'
    toReplace = '../../../101results/101repo/'

    factsFileName = filePath.replace(toReplace, '') + extractorExt
    factsFilePath = os.path.join(const101.tRoot, factsFileName)

    if not os.path.exists(factsFilePath):
        return False

    extracted = json.load(open(factsFilePath))

    for fragment in extracted['fragments']:
        if search(fragment, classifier, name):
            return True
    else:
        return False

