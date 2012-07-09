#! /usr/bin/env python

import sys
import json

if len(sys.argv) != 3:
    sys.exit("Usage: factAnnotation.py sourceFile attribute")

extractPath = sys.argv[1] + '.extractor.json';
attribute = sys.argv[2];

factsFile = open(extractPath);
facts = json.load(factsFile);

for x in facts["attributes"]:
	if x == attribute:
		sys.exit(0);

sys.exit(1);
