build:
	make jvalidator/JValidator.class

jvalidator/JValidator.class: jvalidator/*.java Makefile
	javac \
		-Xlint \
		-classpath .:lib/javaparser-1.0.8.jar \
		jvalidator/*.java

test: 
	./validator.py example/Serialization.java

clean: 
	rm -f jvalidator/*.class
