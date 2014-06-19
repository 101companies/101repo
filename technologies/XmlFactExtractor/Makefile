# Comments not supported by current parser. Possible with Python3.
#
# BugWrongAttributeLinenumberBecauseMultilineStarttag solved (only workaround), attributes get the same endline value as the parent elements

test: 
	./extractor.py < test/Attribute.xml > test/output/Attribute.json
	./extractor.py < test/Element.xml > test/output/Element.json
	./extractor.py < test/ExcludedComment.xml > test/output/ExcludedComment.json
	./extractor.py < test/IndexedElement.xml > test/output/IndexedElement.json
	./extractor.py < test/IndexedText.xml > test/output/IndexedText.json
	#./extractor.py < test/MultiLineComment.xml > test/output/MultiLineComment.json
	#./extractor.py < test/SingleLineComment.xml > test/output/SingleLineComment.json
	./extractor.py < test/Text.xml > test/output/Text.json
	./extractor.py < test/BugWrongAttributeLinenumberBecauseMultilineStarttag.xml > test/output/BugWrongAttributeLinenumberBecauseMultilineStarttag.json	

	diff --ignore-all-space test/baseline/Attribute.json test/output/Attribute.json
	diff --ignore-all-space test/baseline/Element.json test/output/Element.json
	diff --ignore-all-space test/baseline/ExcludedComment.json test/output/ExcludedComment.json
	diff --ignore-all-space test/baseline/IndexedElement.json test/output/IndexedElement.json
	diff --ignore-all-space test/baseline/IndexedText.json test/output/IndexedText.json
	#diff --ignore-all-space test/baseline/MultiLineComment.json test/output/MultiLineComment.json
	#diff --ignore-all-space test/baseline/SingleLineComment.json test/output/SingleLineComment.json
	diff --ignore-all-space test/baseline/Text.json test/output/Text.json
	diff --ignore-all-space test/baseline/BugWrongAttributeLinenumberBecauseMultilineStarttag.json test/output/BugWrongAttributeLinenumberBecauseMultilineStarttag.json	

	make reset-test
	
reset-test:
	@rm -f test/output/*.json

clean: 
	make reset-test

