#!/usr/bin/python

import sys
import json
import re
import xml.sax as Sax


class FragmentXmlParser(Sax.handler.ContentHandler):
	tree_stack = []
	fragments = {"fragments": []}

	def __init__(self):
		Sax.handler.ContentHandler.__init__(self)

	def get_line_number(self):
		return self._locator.getLineNumber()

	def count_fragments(self, new_fragment):
		fragment_count = 0
		for fragment in self.get_current_position()["fragments"]:
			if fragment["name"] == new_fragment["name"] and fragment["classifier"] == new_fragment["classifier"]:
				fragment_count += 1
		return fragment_count

	def get_current_position(self):
		position = self.fragments
		for fragment_id in self.tree_stack:
			position = position["fragments"][fragment_id]
		return position

	def get_fragment_by_name_and_classifier(self, new_fragment):
		fragment_list = self.get_current_position()["fragments"]
		for fragment in fragment_list:
			if fragment["name"] == new_fragment["name"] and fragment["classifier"] == new_fragment["classifier"]:
				return fragment

	def create_index(self, new_fragment):
		old_index = self.count_fragments(new_fragment)
		if old_index == 1:
			self.get_fragment_by_name_and_classifier(new_fragment)["index"] = 1
			new_fragment['index'] = 2
		elif old_index > 1:
			new_fragment['index'] = old_index + 1

	def add_fragment(self, new_fragment, push_tree_stack):
		self.create_index(new_fragment)
		count_of_fragments = len(self.get_current_position()["fragments"])
		self.get_current_position()["fragments"].append(new_fragment)
		if push_tree_stack:
			self.tree_stack.append(count_of_fragments)

	def set_error_message(self, msg):
		self.fragments['errors'] = msg

	#Begin Override Functions
	def startElement(self, name, attrs):
		self.add_fragment(
			{"name": name, "startLine": self.get_line_number(), "fragments": [], "classifier": "element"}, True)

		for attribute_name in attrs.getNames():
			attribute_fragment = {"name": attribute_name, "startLine": self.get_line_number(),
								  "endLine": self.get_line_number(), "fragments": [], "classifier": "attribute",
								  "value": attrs.getValue(attribute_name)}
			self.get_current_position()["fragments"].append(attribute_fragment)

	def endElement(self, name):
		self.get_current_position()["endLine"] = self.get_line_number()
		#give all attributes the current linenumber as endLine
		for fragment in self.get_current_position()["fragments"]:
			if "attribute" == fragment["classifier"]:
				fragment["endLine"] = self.get_line_number()
		self.tree_stack.pop()

	def characters(self, content):
		if re.search("\S", content):
			end_line = self.get_line_number() + len(content.splitlines()) - 1
			text_fragment = {"name": "text", "startLine": self.get_line_number(), "endLine": end_line,
							 "fragments": [], "classifier": "text"}
			self.add_fragment(text_fragment, False)

	def get_fragments(self):
		return self.fragments

parser = FragmentXmlParser()
parser.feature_external_ges = False
parser.feature_external_pes = False
try:
	Sax.parse(sys.stdin, parser)
except Sax.SAXException as msg:
	parser.set_error_message(str(msg))
print(json.dumps(parser.get_fragments(), indent=2))