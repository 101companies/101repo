#! /usr/bin/env python

import sys
import json

if len(sys.argv) < 3:
    sys.exit("Usage: factAnnotation.py sourceFile attribute [attribute ...]")

extractPath = sys.argv[1] + '.extractor.json';

factsFile = open(extractPath);
facts = json.load(factsFile);

for decl in facts["declarations"]:
	for attr in decl["attributes"]:
		for i in range(2, len(sys.argv)):
			if attr == sys.argv[i]:
				exit()

sys.exit(1);
