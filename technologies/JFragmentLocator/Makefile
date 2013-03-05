build:
	make jfragmentlocator/JFragmentLocator.class

jfragmentlocator/JFragmentLocator.class: jfragmentlocator/*.java Makefile
	javac \
		-Xlint \
		-classpath .:lib/javaparser-1.0.8.jar \
		jfragmentlocator/*.java

test: 
	./locator.py class/Behavior/class/Testclass  < tests/Serialization.java > tests/class.json
	diff tests/class.json tests/class.baseline
	./locator.py class/Behavior/method/testTotal  < tests/Serialization.java > tests/method.json
	diff tests/method.json tests/method.baseline
	./locator.py class/Behavior/class/Testclass/method/mymethod/1  < tests/Serialization.java > tests/overload.json
	diff tests/overload.json tests/overload.baseline


clean: 
	rm -f jfragmentlocator/*.class
	rm -f tests/*.json
