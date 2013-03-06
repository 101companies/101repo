#! /usr/bin/env python

import sys
import json
import os

sys.path.append('../../libraries/101meta')
import const101


if len(sys.argv) < 3:
    sys.exit("Usage: javaImport.py sourceFile import [import ...]")

extractPath = os.path.join(const101.tRoot, sys.argv[1] + '.extractor.json')
imported = sys.argv[2]

factsFile = open(extractPath)
facts = json.load(factsFile)

for x in facts["imports"]:
    for i in range(2, len(sys.argv)):
        if x == sys.argv[i]:
            sys.exit()

sys.exit(1)
