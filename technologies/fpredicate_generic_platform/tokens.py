#! /usr/bin/env python

import sys
import json
import os

data = ''.join(list(sys.stdin))
data = json.loads(data)

if len(sys.argv) != 2:
    sys.exit("Usage: tokens.py sourceFile")

f = sys.argv[1]

extractPath = f + '.refinedTokens.json'

if not os.path.exists(extractPath):
    print json.dumps([False] * len(data))

else:
    factsFile = open(extractPath)
    facts = json.load(factsFile)

# result = []

    print json.dumps(map(lambda i: i in facts.keys(), data))

#for i in data:
#    if i in facts['imports']:
#        result.append(True)
#    else:
#        result.append(False)
#        
#print json.dumps(result)


