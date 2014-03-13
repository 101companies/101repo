#! /usr/bin/env python
import imp
import sys
import json
SqlFactExtractor = imp.load_source('SQLFactExtractor', '../SqlFactExtractor/SQLFactExtractor.py')

def get_table_by_name(sql_fragments, name):
	for statement in sql_fragments["fragments"]:
		if name == statement["fragments"][0]["name"]:
			return statement["fragments"][0]

def get_column_by_name(table, name):
	for column in table["fragments"]:
		if name == column["name"]:
			return column


sql_fragments = SqlFactExtractor.SQLFactExtractor(sys.argv[2], True).extract_file()

# sql_file or
# create_statement/Index or
# table/table_name or
# column/table_name/column_name
fragment_locator = sys.argv[1].split("/")

if SqlFactExtractor.CLASSIFIER_FILE == fragment_locator[0]:
	print(json.dumps({"from" : sql_fragments["line_start"], "to":sql_fragments["line_end"]}))
elif SqlFactExtractor.CLASSIFIER_CREATE == fragment_locator[0]:
	if fragment_locator[1].isdigit():
		element = sql_fragments["fragments"][int(fragment_locator[1])]
		print(json.dumps({"from" : element["line_start"], "to":element["line_end"]}))
	else:
		print("Error: Right Format is create_statement/Index")
elif SqlFactExtractor.CLASSIFIER_TABLE == fragment_locator[0]:
	element = get_table_by_name(sql_fragments, fragment_locator[1])
	print(json.dumps({"from" : element["line_start"], "to":element["line_end"]}))
elif SqlFactExtractor.CLASSIFIER_COLUMN == fragment_locator[0]:
	table = get_table_by_name(sql_fragments, fragment_locator[1])
	element = get_column_by_name(table, fragment_locator[2])
	print(json.dumps({"from" : element["line_start"], "to":element["line_end"]}))
else:
	print("ERROR unknown Fragment-Classifier")
