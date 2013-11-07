test:
	python test.py example/createTable.sql
	diff --ignore-all-space example/testResult.json example/estimatedResult.json
	diff --ignore-all-space example/testResultWithLineNumbers.json example/estimatedResultWithLineNumbers.json

	rm example/testResult.json
	rm example/testResultWithLineNumbers.json
