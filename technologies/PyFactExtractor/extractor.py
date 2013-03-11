#!/usr/bin/python
import ast
from syb import *
import sys
import operator

ls = []
for line in sys.stdin:
    ls.append(line)

source = ''.join(ls)

tree = ast.parse(source)

def normalize(l):
    r = filter(bool, l)
    return r

def filter_non_fragments(b):
    r = filter(lambda f: not isinstance(f, (ast.Continue, ast.Break, ast.Raise, ast.Delete, ast.Expr, ast.Import, ast.ImportFrom, ast.Print, ast.Return, ast.Assert, ast.Pass)), b)
    
    def flatten(l):
        r = []
        for i in l:
            if isinstance(i, list):
                r += flatten(i)
            else:
                r.append(i)
        return r
    
    r = flatten(r)
    return normalize(r)

@t(ast.Module)
def convertModule(m):
    m.body = filter_non_fragments(m.body)
    return {

        'fragments': m.body
        
    }

@t(ast.FunctionDef)
def convertFunction(f):
    f.body = filter_non_fragments(f.body)
    return {
        'classifier': 'function',
        'name': f.name,

        'fragments': (
            f.body
        if f.body else [])
    }

@t(ast.Assign)
def convertAssign(a):
    if isinstance(a.targets[0], ast.Name):
        return {
            'classifier': 'var',
            'name': a.targets[0].id
        }

@t(ast.If)
def convertIf(i):
    body = filter_non_fragments(i.body)
    orelse = filter_non_fragments(i.orelse)
    return body + orelse

@t(ast.For)
def convertFor(f):
    body = filter_non_fragments(f.body)
    orelse = filter_non_fragments(f.orelse)
    return body + orelse

@t(ast.While)
def convertWhile(f):
    body = filter_non_fragments(f.body)
    orelse = filter_non_fragments(f.orelse)
    return body + orelse

@t(ast.TryExcept)
def convertTryExcept(i):
    body = filter_non_fragments(i.body)
    return body

@t(ast.With)
def convertWith(i):
    body = filter_non_fragments(i.body)
    return body

@t(ast.ClassDef)
def convertClassDef(c):
    body = filter_non_fragments(c.body)
    return {

        'classifier': 'class',
        'name': c.name,

        'fragments': (body if body else [])

    }

@t(ast.AugAssign)
def convertAugAssign(a):
    if isinstance(a.target, ast.Name):
        return {
            'classifier': 'var',
            'name': a.target.id
        }

@t(ast.Global)
def convertGlobal(g):
    return []

@t(ast.TryFinally)
def convertTryFinally(t):
    body = filter_non_fragments(t.body)
    orelse = filter_non_fragments(t.finalbody)
    return body + orelse
 
extract = everywhere(id_ |extQ| convertFunction |extQ| convertModule |extQ| convertAssign |extQ| 
    convertIf |extQ| convertTryExcept |extQ| convertClassDef |extQ| convertFor |extQ| convertAugAssign
    |extQ| convertWhile |extQ| convertWith |extQ| convertGlobal |extQ| convertTryFinally)

@t(ast.Import)
def getImport(i):
    return map(lambda i: i.name, i.names)

@t(ast.ImportFrom)
def getImportFrom(i):
    return [i.module]

getImports = everything(operator.add, [] |mkQ| getImport |extQ| getImportFrom)

import json
facts = extract(tree)
facts['imports'] = getImports(tree)
print json.dumps(facts, indent=4, sort_keys=True)


