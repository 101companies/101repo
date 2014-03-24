#! /usr/bin/env python

import sys
sys.path.append('../../libraries/101meta')
import const101
import os
import json

def run(args=None, filePath=None):

    if const101.sRoot in filePath:
        filePath = filePath[len(const101.sRoot) + 1:]

    extractPath = os.path.join(const101.tRoot, filePath + '.extractor.json')

    if not os.path.exists(extractPath):
        return False

    factsFile = open(extractPath)

    facts = json.load(factsFile)
    for x in facts["imports"]:
        for arg in args:
            if x == arg:
                return True
    else:
        return False
