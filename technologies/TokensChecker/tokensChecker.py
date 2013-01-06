#! /usr/bin/env python

import json
import os
import sys
sys.path.append('../../libraries/101meta')
import const101

tokensExt = '.refinedTokens.json'
toReplace = '../../../101results/101repo/'

fileName = sys.argv[len(sys.argv)-1].replace(toReplace, '') + tokensExt
refined = json.load(open(os.path.join(const101.tRoot, fileName)))

terms = []
for i in range(1, len(sys.argv)-1):
	terms.append(sys.argv[i])

if set(terms).issubset(refined):
	sys.exit()

sys.exit(1)
