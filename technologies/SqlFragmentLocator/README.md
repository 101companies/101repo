# Headline

A fragment locator for Sql

# Usage

The executable is "locator.py".

The "/"-based fragment selector is provided as a command-line argument.

The source code on which to apply fragment location is read from stdin. 

The determined line range of the fragment is written in JSON format to stdout.

The following fragment selectors/formats are supported:

* sql_file
* create_statement/Index
* table/table_name
* column/table_name/column_name



# Testing

Test the tool with "make test".

See the Makefile for details.

Fragment location is permformed on example/createTable.sql.

