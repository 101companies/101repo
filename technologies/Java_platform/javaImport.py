#! /usr/bin/env python

import sys
import json

if len(sys.argv) != 3:
    sys.exit("Usage: factImport.py sourceFile import")

extractPath = sys.argv[1] + '.extractor.json';
imported = sys.argv[2];

factsFile = open(extractPath);
facts = json.load(factsFile);

for x in facts["imports"]:
	if x == imported:
		sys.exit(0);

sys.exit(1);
