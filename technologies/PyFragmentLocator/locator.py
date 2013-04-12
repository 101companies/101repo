#! /usr/bin/env python

import commands
import os.path
import json
import sys
from syb import *
import ast
import operator


if len(sys.argv) != 2:
    sys.exit("Usage: locator.py url")

url = sys.argv[1]


def getLatestNode(a):
    @t(ast.expr)
    def getExpr(n):
        return [n]

    @t(ast.stmt)
    def getStmt(n):
        return [n]

    nodes = everything(lambda a, b: a + b, [] |mkQ| getExpr |extQ| getStmt)(a)

    nodes = reduce(lambda a, b: a if a.lineno > b.lineno else b, nodes)
    return nodes

def findFragment(url, tree, top_fragment=None):
    pieces = url.split('/')
    ns, name = pieces[:2]
    new_url = '/'.join(pieces[2:])
    pieces = pieces[2:]
    for i, a in enumerate(tree.body):
        if ns == 'class' and isinstance(a, ast.ClassDef):
            if a.name == name:
                if len(pieces) == 0:
                    return {'from': a.lineno, 'to': getLatestNode(a).lineno }
                else:
                    return findFragment(new_url, a, top_fragment)

        elif ns == 'function' and isinstance(a, ast.FunctionDef):
            if a.name == name:
                if len(pieces) == 0:
                    return {'from': a.lineno, 'to': getLatestNode(a).lineno }
                else:
                    return findFragment(new_url, a, top_fragment)

        elif ns == 'var' and isinstance(a, ast.Assign):
            if a.targets[0].id == name:
                if len(pieces) == 0:
                    return {'from': a.lineno, 'to': a.lineno + 1 }
                else:
                    return findFragment(new_url, a, top_fragment)
                
ls = []
for line in sys.stdin:
    ls.append(line)

source = ''.join(ls)

tree = ast.parse(source)

print json.dumps(findFragment(url, tree))

#output.write(r)

