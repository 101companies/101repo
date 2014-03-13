test:
	./extractor.py < example/createTable.sql > example/testResult.json
	diff --ignore-all-space example/testResult.json example/estimatedResult.json

	rm example/testResult.json

