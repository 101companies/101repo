#! /usr/bin/env python

import sys
import json
import os

sys.path.append('../../libraries/101meta')
import const101


if len(sys.argv) < 3:
    sys.exit("Usage: javaImport.py import [import ...] sourceFile")

path = sys.argv[len(sys.argv) - 1]
if const101.sRoot in path:
    path = path[len(const101.sRoot) + 1:]

extractPath = os.path.join(const101.tRoot, path + '.extractor.json')

factsFile = open(extractPath)
facts = json.load(factsFile)

for x in facts["imports"]:
    for i in range(1, len(sys.argv) - 1):
        if x == sys.argv[i]:
            #exit with status code 0 indicating success - import has been found
            sys.exit()

#exit with status code 1, indicating failure - import has not been found
sys.exit(1)
