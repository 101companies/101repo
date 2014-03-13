#!/usr/bin/python

import json
import sys
import re


class JSONFactExtractor:
	def __init__(self, json_file):
		self.json_file = json_file
		self.line_number_mapping_table = self.create_mapping_table()
		self.ln_char_index_no_doubling = 0

	def extract_facts(self):
		fragments = {'fragments': self.visit(json.loads(self.json_file))}
		return fragments

	def visit(self, to_visit):
		if isinstance(to_visit, dict):
			return self.visit_object(to_visit)
		elif isinstance(to_visit, list):
			return self.visit_list(to_visit)
		else:
			pass

	def visit_object(self, current_object):
		line_numbers = self.find_line_number(current_object)
		new_object = {'fragments': [], 'classifier': 'object', 'name': 'object', 'startLine': line_numbers['startLine'],
					  'endLine': line_numbers['endLine']}
		for key in current_object.keys():
			value = current_object[key]
			if isinstance(value, dict) or isinstance(value, list):
				value_fragment = self.visit(value)
				value_fragment['name'] = key
				new_object['fragments'].append(value_fragment)
		return new_object

	def visit_list(self, current_list):
		line_numbers = self.find_line_number(current_list)
		new_object = {'fragments': [], 'classifier': 'list', 'name': 'list', 'startLine': line_numbers['startLine'],
					  'endLine': line_numbers['endLine']}
		for element in current_list:
			if isinstance(element, dict) or isinstance(element, list):
				new_object['fragments'].append(self.visit(element))
		self.add_indices(new_object)
		return new_object

	@staticmethod
	def add_indices(new_object):
		count_objects = 0
		count_lists = 0
		for fragment in new_object['fragments']:
			if fragment['name'] == 'object':
				count_objects += 1
			elif fragment['name'] == 'list':
				count_lists += 1

		if count_objects > 1:
			actual_index = 1
			for fragment in new_object['fragments']:
				if fragment['name'] == 'object':
					fragment['index'] = actual_index
					actual_index += 1

		if count_lists > 1:
			actual_index = 1
			for fragment in new_object['fragments']:
				if fragment['name'] == 'list':
					fragment['index'] = actual_index
					actual_index += 1

	def find_line_number(self, element_string):
		org_file = re.sub('\s', '', self.json_file)
		find_part = re.sub('\s', '', json.dumps(element_string))

		start_line_index = org_file.find(find_part, self.ln_char_index_no_doubling)
		end_line_index = start_line_index + len(find_part)
		self.ln_char_index_no_doubling = start_line_index + 1

		return {'startLine': self.line_number_mapping_table[start_line_index],
				'endLine': self.line_number_mapping_table[end_line_index - 1]}

	def create_mapping_table(self):
		mt = {}
		cleared_json_file = re.sub('\s', '', self.json_file)

		json_file_index = 0
		json_file_line = 1
		for cleared_json_file_index in range(0, len(cleared_json_file)):
			while self.json_file[json_file_index] != cleared_json_file[cleared_json_file_index]:
				if self.json_file[json_file_index] in ['\r', '\n', '\r\n']:
					json_file_line += 1
				json_file_index += 1
			mt[cleared_json_file_index] = json_file_line
		return mt


#file_name = "example.json"
#base_name = os.path.dirname(os.path.realpath(__file__))
#file_loc = os.path.join(base_name, file_name)
json_file = sys.stdin.read()

extractor = JSONFactExtractor(json_file)
print(json.dumps(extractor.extract_facts(), indent=2))