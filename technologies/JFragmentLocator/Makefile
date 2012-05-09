build:
	make locator/JFragmentLocator.class

locator/JFragmentLocator.class: locator/*.java Makefile
	javac \
		-Xlint \
		-classpath .:lib/gson-1.7.1.jar:lib/javaparser-1.0.8.jar \
		locator/*.java

test: 
	./locator.py HelloWorld.java fragment.json lines.json
	diff baseline.json lines.json

clean: 
	rm -f locator/*.class
	rm -f lines.json
