# Comments not supported

test: 
	./extractor.py < test/AlterStatement.sql > test/output/AlterStatement.json
	./extractor.py < test/Column.sql > test/output/Column.json
	./extractor.py < test/CreateStatement.sql > test/output/CreateStatement.json
	./extractor.py < test/IndexedAlterStatement.sql > test/output/IndexedAlterStatement.json
		
	diff --ignore-all-space test/baseline/AlterStatement.json test/output/AlterStatement.json
	diff --ignore-all-space test/baseline/Column.json test/output/Column.json
	diff --ignore-all-space test/baseline/CreateStatement.json test/output/CreateStatement.json
	diff --ignore-all-space test/baseline/IndexedAlterStatement.json test/output/IndexedAlterStatement.json

	make reset-test
	
reset-test:
	@rm -f test/output/*.json

clean: 
	make reset-test

