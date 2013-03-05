build:
	make jfactextractor/JFactExtractor.class

jfactextractor/JFactExtractor.class: jfactextractor/*.java Makefile
	javac \
		-Xlint \
		-classpath .:lib/gson-1.7.1.jar:lib/javaparser-1.0.8.jar \
		jfactextractor/*.java

test: 
	./extractor.py < example/Serialization.java > example/facts_simple.json
	diff --ignore-all-space example/simple.baseline example/facts_simple.json
	./extractor.py < example/Cut.java > example/facts_overload.json
	diff --ignore-all-space example/overload.baseline example/facts_overload.json
clean: 
	@rm -f jfactextractor/*.class
	@rm -f example/*.json
