#! /usr/bin/env python

import sys
import json
import os

data = ''.join(list(sys.stdin))
data = json.loads(data)

if len(sys.argv) != 2:
    sys.exit("Usage: import.py sourceFile")

f = sys.argv[1]

extractPath = f + '.extractor.json'

factsFile = open(extractPath)
facts = json.load(factsFile)

result = []

print json.dumps(map(lambda i: i in facts['imports'], data))

#for i in data:
#    if i in facts['imports']:
#        result.append(True)
#    else:
#        result.append(False)
#        
#print json.dumps(result)


