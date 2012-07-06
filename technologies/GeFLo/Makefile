build:
	make geflo.jar

geflo.jar: src/geflo/*/*.java src/geflo/*/*/*.java Makefile
	mkdir -p bin
	javac \
		-nowarn \
		-encoding UTF-8 \
		-cp ./src:./libs/* \
		-d bin \
		src/geflo/main/*.java
	jar cf geflo.jar bin/geflo/main/*.class

test: build
	make junit
	make total.test
	make cut.test

junit:
	java \
		-cp libs/junit-4.10.jar:bin \
		org.junit.runner.JUnitCore \
		geflo.main.TestsOnExampleScript

%.test:
	./locator.py data/company.rb data/$*.geflo data/$*.lines
	diff data/$*.baseline data/$*.lines

clean:
	rm -rf bin
	rm -f data/*.lines
	rm -f geflo.jar
