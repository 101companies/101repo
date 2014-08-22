# Parser is not supporting depracated single-tags line <br>
# The problem is, it is searching for a closing tag

test: 
	./extractor.py < test/Attribute.html > test/output/Attribute.json
	./extractor.py < test/ExcludedComment.html > test/output/ExcludedComment.json
	./extractor.py < test/IndexedTag.html > test/output/IndexedTag.json
	./extractor.py < test/IndexedText.html > test/output/IndexedText.json
	./extractor.py < test/MultiLineComment.html > test/output/MultiLineComment.json
	./extractor.py < test/Nested.html > test/output/Nested.json
	./extractor.py < test/SingleLineComment.html > test/output/SingleLineComment.json
	./extractor.py < test/Tag.html > test/output/Tag.json
	./extractor.py < test/Text.html > test/output/Text.json
	./extractor.py < test/BugDeprecatedAtomicTags.html > test/output/BugDeprecatedAtomicTags.json
		
	diff --ignore-all-space test/baseline/Attribute.json test/output/Attribute.json
	diff --ignore-all-space test/baseline/ExcludedComment.json test/output/ExcludedComment.json
	diff --ignore-all-space test/baseline/IndexedTag.json test/output/IndexedTag.json
	diff --ignore-all-space test/baseline/IndexedText.json test/output/IndexedText.json
	diff --ignore-all-space test/baseline/MultiLineComment.json test/output/MultiLineComment.json
	diff --ignore-all-space test/baseline/Nested.json test/output/Nested.json
	diff --ignore-all-space test/baseline/SingleLineComment.json test/output/SingleLineComment.json
	diff --ignore-all-space test/baseline/Tag.json test/output/Tag.json
	diff --ignore-all-space test/baseline/Text.json test/output/Text.json
	diff --ignore-all-space test/baseline/BugDeprecatedAtomicTags.json test/output/BugDeprecatedAtomicTags.json

	make reset-test
	
reset-test:
	@rm -f test/output/*.json

clean: 
	make reset-test

