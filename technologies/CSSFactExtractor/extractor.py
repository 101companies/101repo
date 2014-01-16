#!/usr/bin/python

import tinycss
import sys
import re
import json


def get_end_line(line_number):
	css_file_as_lines = css_file.splitlines()
	open_brackets = 0
	while line_number <= len(css_file_as_lines):
		open_brackets += len(re.findall("{", css_file_as_lines[line_number - 1]))
		open_brackets -= len(re.findall("}", css_file_as_lines[line_number - 1]))
		if open_brackets == 0:
			return line_number
		if open_brackets < 0:
			print("Parsing Error: In get_end_line()")
		line_number += 1


parser = tinycss.make_parser('page3')
css_file = sys.stdin.read()
stylesheet = parser.parse_stylesheet_bytes(css_file)

fragments = {'fragments': []}
for rule in stylesheet.rules:
	fragments['fragments'].append(
		{'name': str(rule.selector.as_css()), 'startLine': rule.line, 'endLine': get_end_line(rule.line),
		 'fragments': [], 'classifier': 'rule'})
	for declaration in rule.declarations:
		parent = fragments['fragments'][len(fragments['fragments']) - 1]
		parent['fragments'].append({'name': declaration.name, 'startLine': declaration.line, 'endLine': declaration.line,
		 'fragments': [], 'classifier': 'declaration', 'value': str(declaration.value.as_css())})

print(json.dumps(fragments, indent=2))