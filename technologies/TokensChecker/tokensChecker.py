#! /usr/bin/env python

import json
import os
import sys
sys.path.append('../../libraries/101meta')
import const101

def run(args=None, filePath=None):

    tokensExt = '.refinedTokens.json'
    toReplace = '../../../101results/101repo/'

    fileName = filePath.replace(toReplace, '') + tokensExt
    tokenFile = os.path.join(const101.tRoot, fileName)
    if not os.path.exists(tokenFile):
        return False

    refined = json.load(open(tokenFile))
    terms = []

    for arg in args:
        terms.append(arg)

    if set(terms).issubset(refined):
        return True
    else:
        return False