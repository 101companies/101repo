test:
	
	./locator.py sql_file example/createTable.sql > example/testResultFile.json
	diff --ignore-all-space example/estimatedResultFile.json example/testResultFile.json

	./locator.py create_statement/1 example/createTable.sql > example/testResultCreate.json
	diff --ignore-all-space example/estimatedResultCreate.json example/testResultCreate.json

	./locator.py table/COMPANY example/createTable.sql > example/testResultTable.json
	diff --ignore-all-space example/estimatedResultTable.json example/testResultTable.json

	./locator.py column/COMPANY/name example/createTable.sql > example/testResultColumn.json
	diff --ignore-all-space example/estimatedResultColumn.json example/testResultColumn.json

	rm example/testResultFile.json
	rm example/testResultCreate.json
	rm example/testResultTable.json
	rm example/testResultColumn.json

