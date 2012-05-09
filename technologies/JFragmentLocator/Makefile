generate:
	javac -Xlint -classpath .:lib/gson-1.7.1.jar:lib/javaparser-1.0.8.jar locator/Fragment.java locator/Tupel.java locator/JFragmentLocator.java

test: 
	java -classpath .:lib/gson-1.7.1.jar:lib/javaparser-1.0.8.jar locator/JFragmentLocator HelloWorld.java fragment.json lines.json
	diff -w baseline.json lines.json
	
clean: 
	rm -f locator/*.class
	rm lines.json
