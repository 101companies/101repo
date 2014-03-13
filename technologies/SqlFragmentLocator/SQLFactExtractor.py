import sqlparse
import sys
import json
import re
from SQLClassifier import *

class SQLFactExtractor(object):
	"""docstring for SQLFactExtractor"""

	def enumerate_auto(*sequential, **named):
		enums = dict(zip(sequential, range(len(sequential))), **named)
		return type('Enum', (), enums)

	StatementType = enumerate_auto(
		'CREATE',
		'ALTER',
		'UNKNOWN'
	)

	ExpectedToken = enumerate_auto(
		'NONE',
		'BEGIN',
		'VARIABLE_NAME',
		'VARIABLE_TYPE'
	)

	def __init__(self, file, log_code):
		self.sqlDatei = file
		self.load_reserved_sql_keywords()
		self.log_code = log_code
		
	def load_reserved_sql_keywords(self):
		self.reserved_keywords = []
		for line in open("sqlKeyWords.txt", "r"):
			self.reserved_keywords.append(str.lower(line.rstrip()))
	
	def get_statement_type(self,statement):
		for my_token in statement.tokens:
			if str.upper(str(my_token)) == "CREATE":
				return self.StatementType.CREATE
			elif str.upper(str(my_token)) == "ALTER":
				return self.StatementType.ALTER
		return self.StatementType.UNKNOWN

	def miss_whitespace(self,tokens_generator_elem):
		while tokens_generator_elem.is_whitespace():
			tokens_generator_elem = tokens_generator_elem.next();
			return tokens_generator_elem

	def extract_file(self):
		fragment_result = {"classifier": CLASSIFIER_FILE, "fragments": []}
		constraints_list = []

		for each in sqlparse.parse(open(self.sqlDatei).read()):
			if each.get_type() != "UNKNOWN":
				statement_type = self.get_statement_type(each)
				if self.StatementType.CREATE == statement_type:#create
					self.extract_create_statement(each, fragment_result)
				elif self.StatementType.ALTER == statement_type:#alter
					self.extract_alter_statement(each, constraints_list)

		self.add_contraints(fragment_result, constraints_list)
		if self.log_code:
			self.add_code_linenumbers(fragment_result)	

		return fragment_result

	def extract_create_statement(self, each, fragment_result):
		subject_token = None
		item_list = []
		expected_token = self.ExpectedToken.BEGIN
		
		#get Relevant Data
		for token in each.tokens:
			#print(dir(token))
			#print(token.value)
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
		statement_fragment = {"classifier": CLASSIFIER_CREATE, "fragments": []}
		table_fragment = {"classifier": CLASSIFIER_TABLE, "name": str(subject_token), "fragments": []}
		i = 0
		while i < len(item_list):
			table_fragment["fragments"].append(
				{"classifier": CLASSIFIER_COLUMN, "name": item_list[i], "type": item_list[i + 1], "fragments": []})
			i += 2
		statement_fragment["fragments"].append(table_fragment)
		fragment_result["fragments"].append(statement_fragment)

		self.add_code_to_fragments(each, statement_fragment)


	def extract_alter_statement(self, each, constraints_list):
		subject_table = None
		constraint_name = ""
		foreign_key_var = ""
		references = ""
		#get Relevant Data
		i = 0
		while str.lower(str(each.tokens[i])) in ['alter', 'table'] or each.tokens[i].is_whitespace():
			i += 1
		subject_table = str(each.tokens[i])
		while str.lower(str(each.tokens[i])) != 'constraint' or each.tokens[i].is_whitespace():
			i += 1
		constraint_name = str(each.tokens[i + 2])
		while (str.lower(str(each.tokens[i])) != 'foreign' and str.lower(str(each.tokens[i + 2])) != 'key') or \
				each.tokens[i].is_whitespace():
			i += 1
		foreign_key_var = str(each.tokens[i + 4])
		foreign_key_var = foreign_key_var[1:len(foreign_key_var) - 1]
		while str.lower(str(each.tokens[i])) != 'references' or each.tokens[i].is_whitespace():
			i += 1
		references = str(each.tokens[i + 2])

		constraints_list.append({
		"subject_table": subject_table,
		"constraint_name": constraint_name,
		"foreign_key_var": foreign_key_var,
		"references": references
		})

	def add_code_to_fragments(self, each, statement_fragment):
		if self.log_code:
			statement_fragment["code"] = str(each)
			statement_fragment["fragments"][0]["code"] = self.delete_beginning_control_characters(self.remouve_beginning_create(str(each)))

			#filter column code
			long_string = str(each)
			long_string = long_string[long_string.find("(")+1:]
			column_code_list = self.format_end_of_column_generation( long_string.split(","))

			for column_id in range(0, len(statement_fragment["fragments"][0]["fragments"])):
				statement_fragment["fragments"][0]["fragments"][column_id]["code"] = self.delete_beginning_control_characters(column_code_list[column_id])

	def remouve_beginning_create(self, code_string):
		return code_string[code_string.find("table"):]

	def format_end_of_column_generation(self, column_codes):
		column_codes[-1] = self.delete_last_char_if_equals(column_codes[-1], ";")
		column_codes[-1] = self.delete_last_char_if_equals(column_codes[-1], ")")

		return column_codes

	def delete_last_char_if_equals(self, string, char):
		if char == string[-1]:
			string = string[:-1]
		return string

	def delete_beginning_control_characters(self, string):
		return string[re.search("\w",string).start() :]

	def add_contraints(self, fragment_result, constraints_list):
		for constraint in constraints_list:
			#find table
			for create in fragment_result["fragments"]:
				if create["fragments"][0]["name"] == constraint["subject_table"]:
					#find column
					for column in create["fragments"][0]["fragments"]:
						if column["name"] == constraint["foreign_key_var"]:
							column["constraints"] = [{
													 "type": "foreign_key",
													 "references": constraint["references"],
													 "name": constraint["constraint_name"]
													 }]	
	
	def add_code_linenumbers(self, fragment_result):
		self.add_file_linenumbers(fragment_result)

		self.add_fragment_linenumbers(fragment_result["fragments"], 1, self.get_file_length(self.sqlDatei))

	def add_fragment_linenumbers(self, fragment_pointer, start, end):
		if type(fragment_pointer) == list:
			for frag_elem in fragment_pointer:
				self.add_fragment_linenumbers(frag_elem, start, end)
		elif type(fragment_pointer) == dict:
			self.derive_linenumber(fragment_pointer, start, end)
			self.add_fragment_linenumbers(fragment_pointer["fragments"], fragment_pointer["line_start"], fragment_pointer["line_end"])
		else:
			print("ERROR: add_code_linenumbers UNKNOWN type:"+str(type(fragment_pointer)))

	def derive_linenumber(self, fragment_pointer, start, end):
		open_file = open(self.sqlDatei, "r")

		self.go_to_line(open_file, start)

		char_pointer_fragment = 0
		line_counter = start
		start_line = start
		while char_pointer_fragment < len(fragment_pointer["code"]):
			char = open_file.read(1)
			if("\n" == char):
				line_counter += 1
			if char == fragment_pointer["code"][char_pointer_fragment]:
				if char_pointer_fragment == 0:
					start_line = line_counter
				char_pointer_fragment += 1
			else:
				char_pointer_fragment = 0

		fragment_pointer["line_start"] = start_line
		fragment_pointer["line_end"] = line_counter

	def go_to_line(self, open_file, start):
		for times in range(1,start):
			open_file.readline()

	def add_file_linenumbers(self, fragment_result):
		fragment_result["line_start"] = 1
		fragment_result["line_end"] = self.get_file_length(self.sqlDatei)

	def get_file_length(self, file_string):
		linenumber = 0
		for line in open(self.sqlDatei):
			linenumber += 1
		return linenumber
