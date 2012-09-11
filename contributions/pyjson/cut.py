#! /usr/bin/env python

import sys
import json

def cut(object):
    if "salary" in object:
        object["salary"] /= 2
    else:
        if "manager" in object:
            cut(object["manager"])
        if "departments" in object:
            for d in object["departments"]:
                cut(d)
        if "employees" in object:
            for e in object["employees"]:
                cut(e)        

company = json.load(open(sys.argv[1], 'r'))
cut(company)
open(sys.argv[2], 'w').write(json.dumps(company))
