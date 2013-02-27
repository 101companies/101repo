build:
	make jfactextractor/JFactExtractor.class

jfactextractor/JFactExtractor.class: jfactextractor/*.java Makefile
	javac \
		-Xlint \
		-classpath .:lib/gson-1.7.1.jar:lib/javaparser-1.0.8.jar \
		jfactextractor/*.java

test: 
	./extractor.py < example/Serialization.java > example/facts.json
	diff --ignore-all-space example/baseline.json example/facts.json
clean: 
	@rm -f jfactextractor/*.class
	@rm -f example/facts.json
