#! /usr/bin/env python

import json
import os
import sys
sys.path.append('../../libraries/101meta')
import const101

tokensExt = '.refinedTokens.json'
toReplace = '../../../101results/101repo/'

fileName = sys.argv[len(sys.argv)-1].replace(toReplace, '') + tokensExt
filePath = os.path.join(const101.tRoot, fileName)
if not os.path.exists(filePath):
	sys.exit(1)
refined = json.load(open(filePath))

terms = []
for i in range(1, len(sys.argv)-1):
	terms.append(sys.argv[i])

if set(terms).issubset(refined):
	sys.exit()

sys.exit(1)
