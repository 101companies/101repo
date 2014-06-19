build:
	make jfactextractor/JFactExtractor.class

jfactextractor/JFactExtractor.class: jfactextractor/*.java Makefile
	javac \
		-Xlint \
		-classpath .:lib/gson-1.7.1.jar:lib/javaparser-1.0.8.jar \
		jfactextractor/*.java

test: 
	./extractor.py < test/Basic.java > test/output/Basic.json
	diff --ignore-all-space test/baseline/Basic.baseline test/output/Basic.json
	./extractor.py < test/Indexing.java > test/output/Indexing.json
	diff --ignore-all-space test/baseline/Indexing.baseline test/output/Indexing.json
	./extractor.py < test/SingleLineComment.java > test/output/SingleLineComment.json
	./extractor.py < test/MultiLineComment.java > test/output/MultiLineComment.json
	./extractor.py < test/CommentExcluded.java > test/output/CommentExcluded.json
	diff --ignore-all-space test/baseline/SingleLineComment.baseline test/output/SingleLineComment.json
	diff --ignore-all-space test/baseline/MultiLineComment.baseline test/output/MultiLineComment.json
	diff --ignore-all-space test/baseline/CommentExcluded.baseline test/output/CommentExcluded.json
	./extractor.py < test/Import.java > test/output/Import.json
	./extractor.py < test/Package.java > test/output/Package.json
	diff --ignore-all-space test/baseline/Import.baseline test/output/Import.json
	diff --ignore-all-space test/baseline/Package.baseline test/output/Package.json

	make reset-test

reset-test:
	@rm -f test/output/*.json

clean: 
	@rm -f jfactextractor/*.class
	make reset-test
