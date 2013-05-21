#! /usr/bin/env python


import sys
import json
import xml.sax
from xml.sax.handler import ContentHandler

root = None
stack = []

class Fragment():
    def __init__(self, name, start):
        self.name = name
        self.startLine = start
        self.children = []

        if not stack == []:
            stack[-1].children.append(self)

        stack.append(self)

    def finish(self, end):
        self.endLine = end
        stack.pop()

    def __str__(self):
        return json.dumps({'from' : self.startLine, 'to' : self.endLine})

class FragmentContentHandler(ContentHandler):
    def __init__(self):
        ContentHandler.__init__(self)

    def startElement(self, name, attrs):
        global root

        loc = self._locator
        line = loc.getLineNumber()

        f = Fragment(name, line)
        if not root:
            root = f

    def endElement(self, name):
        loc = self._locator
        line = loc.getLineNumber()

        stack[-1].finish(line)

class Query():
    def __init__(self, queryString):
        self.queryParts = queryString.split('/')

    def next(self):
        if self.queryParts == []:
            raise StopIteration

        part = {'name' : self.queryParts.pop(0), 'index' : 0}

        if len(self.queryParts) > 0 and self.queryParts[0].isdigit():
            part['index'] = int(self.queryParts.pop(0))

        return part

    def __iter__(self):
        return self

#query = Query('xs:schema/xs:element/1/xs:complexType')
query = Query(sys.argv[1])
xml.sax.parse(sys.stdin, FragmentContentHandler())

curNodes = [ root ]
selected = None
for part in query:
    for node in curNodes:
        if node.name == part['name']:
            if part['index'] == 0:
                selected = node
                curNodes = node.children
                break
            else:
                part['index'] -= 1

print selected
