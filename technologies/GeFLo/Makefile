build: Locator

Locator: *.java Makefile
	mkdir bin
	javac \
		-nowarn \
		-encoding UTF-8 \
		-classpath src;libs/* \
		-d bin \
		src/geflo/main/*.java
	jar cf geflo.jar bin/geflo/main/*.class

test: Locator
	make total.test
	make cut.test

%.test:
	java -cp libs/junit-4.10.jar;src org.junit.runner.JUnitCore src/geflo/main/TestOnExampleScript.java
	./locator.py data/$*.geflo data/company.rb data/$*.lines
	diff data/$*.baseline data/$*.lines

clean:
	rm -rf bin
	rm -f data/*.lines
	rm -f geflo.jar
