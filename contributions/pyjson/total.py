#! /usr/bin/env python

import sys
import simplejson as json

def total(object):
    global result
    if "salary" in object:
        result += object["salary"]
    else:
        if "manager" in object:
            total(object["manager"])
        if "departments" in object:
            for d in object["departments"]:
                total(d)
        if "employees" in object:
            for e in object["employees"]:
                total(e)        

company = json.load(open(sys.argv[1], 'r'))
result = 0
total(company)
print result
