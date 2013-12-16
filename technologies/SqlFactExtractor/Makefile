test:
	./extractor.py < example/createTable.sql > example/testResult.json
	./testResultWithLineNumbers.py < example/createTable.sql > example/testResultWithLineNumbers.json

	diff --ignore-all-space example/testResult.json example/estimatedResult.json
	diff --ignore-all-space example/testResultWithLineNumbers.json example/estimatedResultWithLineNumbers.json

	rm example/testResult.json
	rm example/testResultWithLineNumbers.json

