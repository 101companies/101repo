#! /usr/bin/env python


import xml.etree.ElementTree as ET
import json
import sys

def extract(element):
	fragment = {
		'classifier': 'element',
		'name'		: element.tag.split("}")[1][0:],
		'attributes': element.attrib,
		'fragments' : []
	}
	for child in element:
		fragment['fragments'].append(extract(child))
	return fragment

text = ''.join(sys.stdin.readlines())
root = ET.fromstring(text)
facts = {
	'fragments' : [ extract(root) ]
}

print json.dumps(facts, indent=4)
