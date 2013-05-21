#!/usr/bin/python

import sys
import json
import xml.sax
from xml.sax.handler import ContentHandler

root = None
stack = []

class FragmentContentHandler(ContentHandler):
    def __init__(self):
        ContentHandler.__init__(self)

    def startElement(self, name, attrs):
        global root
        global stack

        if not root:
            root = {
                'name' : name,
                'classifier' : 'element',
                'fragments' : []
            }
            stack.append(root)
        else:
            f_new = {
                'name': name,
                'classifier': 'element',
                'fragments': []
            }
            idx = 0
            for fragment in stack[-1]['fragments']:
                if fragment['name'] == f_new['name']:
                    idx += 1
            if idx > 0:
                f_new['index'] = idx

            stack[-1]['fragments'].append(f_new)
            stack.append(f_new)


    def endElement(self, name):
        global stack
        stack.pop()



xml.sax.parse(sys.stdin, FragmentContentHandler())
facts = {
    'imports' : [],
    'fragments' : [ root ]
}

print json.dumps(facts, indent=4)
