import os
import sqlparse
import re

from SQLClassifier import *


class SQLFactExtractor(object):
	"""docstring for SQLFactExtractor"""

	def enumerate_auto(*sequential, **named):
		enums = dict(zip(sequential, range(len(sequential))), **named)
		return type('Enum', (), enums)

	StatementType = enumerate_auto('CREATE', 'ALTER', 'UNKNOWN')
	ExpectedToken = enumerate_auto('NONE', 'BEGIN', 'VARIABLE_NAME', 'VARIABLE_TYPE')

	def __init__(self, sql_file):
		self.sql_file = sql_file
		self.reserved_keywords = []
		self.load_reserved_sql_keywords()

	def load_reserved_sql_keywords(self):
		file_name = "sqlKeyWords.txt"
		base_name = os.path.dirname(os.path.realpath(__file__))
		file_loc = os.path.join(base_name, file_name)
		for line in open(file_loc, "r"):
			self.reserved_keywords.append(str.lower(line.rstrip()))

	def extract_file(self):
		fragment_result = {"fragments": []}

		for each in sqlparse.parse(self.sql_file.read()):
			if each.get_type() != "UNKNOWN":
				statement_type = self.get_statement_type(each)
				if self.StatementType.CREATE == statement_type:  # create
					self.extract_create_statement(each, fragment_result)
				elif self.StatementType.ALTER == statement_type:  # alter
					self.extract_alter_statement(each, fragment_result)

		self.add_code_line_numbers(fragment_result)
		self.add_alter_statement_indexes(fragment_result)

		return fragment_result

	@staticmethod
	def extract_alter_statement(each, fragment_result):
		fragment_result["fragments"].append({"classifier": CLASSIFIER_ALTER, "name": CLASSIFIER_ALTER, "fragments": [], "code": str(each)})

	def extract_create_statement(self, each, fragment_result):
		subject_token = None
		item_list = []
		expected_token = self.ExpectedToken.BEGIN

		#get Relevant Data
		for token in each.tokens:
			if str(token) not in ['create', 'table'] and not token.is_whitespace() and str(token) != ";":
				subject_token = token.flatten().next()
				for sub_token in token.flatten():
					if self.ExpectedToken.BEGIN == expected_token and '(' in str(sub_token):
						expected_token = self.ExpectedToken.VARIABLE_NAME
					elif self.ExpectedToken.VARIABLE_NAME == expected_token and not sub_token.is_whitespace():
						if str.lower(str(sub_token)) in self.reserved_keywords:
							expected_token = self.ExpectedToken.NONE
						else:
							item_list.append(str(sub_token))
							expected_token = self.ExpectedToken.VARIABLE_TYPE
					elif self.ExpectedToken.VARIABLE_TYPE == expected_token and not sub_token.is_whitespace():
						item_list.append(str(sub_token))
						expected_token = self.ExpectedToken.NONE
					elif self.ExpectedToken.NONE == expected_token and ',' in str(sub_token):
						expected_token = self.ExpectedToken.VARIABLE_NAME
		# create fragments as JSON
		create_fragment = {"classifier": CLASSIFIER_CREATE, "name": str(subject_token), "fragments": []}
		i = 0
		while i < len(item_list):
			create_fragment["fragments"].append(
				{"classifier": CLASSIFIER_COLUMN, "name": item_list[i], "type": item_list[i + 1], "fragments": []}
			)
			i += 2
		fragment_result["fragments"].append(create_fragment)

		self.add_code_to_fragments(each, create_fragment)

	def add_code_line_numbers(self, fragment_result):
		self.add_fragment_line_numbers(fragment_result["fragments"], 1, self.get_file_length())

	def add_fragment_line_numbers(self, fragment_pointer, start, end):
		if type(fragment_pointer) == list:
			for frag_elem in fragment_pointer:
				self.add_fragment_line_numbers(frag_elem, start, end)
		elif type(fragment_pointer) == dict:
			self.derive_line_numbers(fragment_pointer, start, end)
			self.add_fragment_line_numbers(fragment_pointer["fragments"], fragment_pointer["startLine"],
											fragment_pointer["endLine"])
		else:
			print("ERROR: add_code_line_numbers UNKNOWN type:" + str(type(fragment_pointer)))

	def derive_line_numbers(self, fragment_pointer, start, end):
		open_file = self.sql_file
		position_in_file = self.sql_file.tell()
		open_file.seek(0)

		self.go_to_line(open_file, start)

		char_pointer_fragment = 0
		line_counter = start
		start_line = start
		while char_pointer_fragment < len(fragment_pointer["code"]):
			char = open_file.read(1)
			if "\n" == char:
				line_counter += 1
			if char == fragment_pointer["code"][char_pointer_fragment]:
				if char_pointer_fragment == 0:
					start_line = line_counter
				char_pointer_fragment += 1
			else:
				char_pointer_fragment = 0

		fragment_pointer["startLine"] = start_line
		fragment_pointer["endLine"] = line_counter
		fragment_pointer.pop("code")

		self.sql_file.seek(position_in_file)

	def go_to_line(self, open_file, start):
		for times in range(1, start):
			open_file.readline()

	def get_file_length(self):
		position_in_file = self.sql_file.tell()
		self.sql_file.seek(0)

		line_number = 0
		for _ in self.sql_file:
			line_number += 1

		self.sql_file.seek(position_in_file)
		return line_number

	def get_statement_type(self, statement):
		for my_token in statement.tokens:
			if str.upper(str(my_token)) == "CREATE":
				return self.StatementType.CREATE
			elif str.upper(str(my_token)) == "ALTER":
				return self.StatementType.ALTER
		return self.StatementType.UNKNOWN

	def add_code_to_fragments(self, each, statement_fragment):
		statement_fragment["code"] = str(each)

		#filter column code
		long_string = str(each)
		long_string = long_string[long_string.find("(") + 1:]
		column_code_list = self.format_end_of_column_generation(long_string.split(","))

		for column_id in range(0, len(statement_fragment["fragments"])):
			statement_fragment["fragments"][column_id]["code"] = self.delete_beginning_control_characters(
				column_code_list[column_id])

	def format_end_of_column_generation(self, column_codes):
		column_codes[-1] = self.delete_last_char_if_equals(column_codes[-1], ";")
		column_codes[-1] = self.delete_last_char_if_equals(column_codes[-1], ")")

		return column_codes

	def delete_last_char_if_equals(self, string, char):
		if char == string[-1]:
			string = string[:-1]
		return string

	def delete_beginning_control_characters(self, string):
		return string[re.search("\w", string).start():]

	def add_alter_statement_indexes(self, fragment_result):
		if self.count_alter_statements(fragment_result) > 1:
			index = 1
			for fragment in fragment_result["fragments"]:
				if "alter_statement" == fragment["classifier"]:
					fragment["index"] = index
					index += 1

	def count_alter_statements(self, fragment_result):
		count = 0
		for fragment in fragment_result["fragments"]:
			if fragment["classifier"] == CLASSIFIER_ALTER:
				count += 1
		return count
