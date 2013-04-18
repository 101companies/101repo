#! /usr/bin/env python

import sys
import json
import os

sys.path.append('../../libraries/101meta')
import const101


def hasAnnotation(annotation, fragments):
    for fragment in fragments:
        #search in current fragment
        for anno in fragment.get('annotations', []):
            if anno == annotation:
                return True

        #search in sub fragments
        if hasAnnotation(annotation, fragment.get('fragments', [])):
            return True

    return False


if len(sys.argv) < 3:
    sys.exit("Usage: javaAnnotation.py attribute [attribute ...] sourceFile")

path = sys.argv[len(sys.argv) - 1]
if const101.sRoot in path:
    path = path[len(const101.sRoot) + 1:]

extractPath = os.path.join(const101.tRoot, path + '.extractor.json')

factsFile = open(extractPath)
facts = json.load(factsFile)

for i in range(1, len(sys.argv) - 1):
    if hasAnnotation(sys.argv[i], facts['fragments']):
        #exit with status code 0 indicating success - import has been found
        sys.exit()

#exit with status code 1, indicating failure - import has not been found
sys.exit(1)
