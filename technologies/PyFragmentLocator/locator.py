#! /usr/bin/env python

import commands
import os.path
import json
import sys
from syb import *
import ast
import operator

def parsePythonFile(path):
    with open(path, 'r') as f:
        return ast.parse(f.read(), path)


def createFinder(type, name_accessor):

    def findItem(path, name):

        @t(list)
        def getItem(c):
            for i, item in enumerate(c):
                if isinstance(item, type) and name_accessor(item) == name:
                    start = item.lineno
                    end = c[i+1].lineno - 1
                    return {'from': start, 'to': end}
            
            return []

        a = parsePythonFile(path)

        f = everything(lambda a, b: a or b, [] |mkQ| getItem)
        return f(a)

    return findItem

findClass = createFinder(ast.ClassDef, lambda c: c.name)
findVariable = createFinder(ast.Assign, lambda c: c.targets[0].id if isinstance(c.targets[0], ast.Name) else '$')
findFunction = createFinder(ast.FunctionDef, lambda c: c.name)

def findMethod(path, name, cls_name):

    @t(ast.ClassDef)
    def getCls(c):
        if c.name == cls_name:
            return c

    a = parsePythonFile(path)

    cls = everything(lambda a, b: a or b, None |mkQ| getCls)(a)
    
    for i, item in enumerate(cls.body):
        if isinstance(item, ast.FunctionDef) and item.name == name:
            start = item.lineno
            try:
                end = cls.body[i+1].lineno - 1
            except IndexError:
                end = findClass(path, cls_name)['end']
            return {'from': start, 'to': end}


#print findClass('101companies.py', 'Company')
#print findVariable('101companies.py', 'cut')
#print findMethod('101companies.py', '__str__', 'Company')

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
    pieces = '/'.join(pieces[2:])
    pieces = pieces[2:]
    for i, a in enumerate(tree.body):
        if ns == 'class' and isinstance(a, ast.ClassDef):
            if a.name == name:
                if len(pieces) == 0:
                    return {'from': a.lineno, 'to': getLatestNode(a).lineno + 1 }
                else:
                    return findFragment(url, tree, top_fragment)

        elif ns == 'function' and isinstance(a, ast.FunctionDef):
            if a.name == name:
                if len(pieces) == 0:
                    return {'from': a.lineno, 'to': getLatestNode(a).lineno + 1 }
                else:
                    return findFragment(url, tree, top_fragment)

        elif ns == 'var' and isinstance(a, ast.Assign):
            if a.targets[0].id == name:
                if len(pieces) == 0:
                    return {'from': a.lineno, 'to': a.lineno + 1 }
                else:
                    return findFragment(url, tree, top_fragment)
                
ls = []
for line in sys.stdin:
    ls.append(line)

source = ''.join(ls)

tree = ast.parse(source)

print json.dumps(findFragment(url, tree))

#output.write(r)

