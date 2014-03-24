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

def run(args=None, filePath=None):

    if const101.sRoot in filePath:
        filePath = filePath[len(const101.sRoot) + 1:]

    extractPath = os.path.join(const101.tRoot, filePath + '.extractor.json')

    if not os.path.exists(extractPath):
        return False

    factsFile = open(extractPath)

    facts = json.load(factsFile)
    for arg in args:
        if hasAnnotation(arg, facts['fragments']):
            #return True, indicating success - import has been found
            return True
    else:
        return False # indicating failure - import has not been found


