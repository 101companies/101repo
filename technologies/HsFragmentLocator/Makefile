l = ./locator.py tests/Test.hs

build: Locator

Locator: *.hs Makefile
	ghc Locator.hs

test: Locator
	${l} function/g > log
	diff tests/function1.baseline log
	rm -f log
	make data.test-json
	make function1.test-json
	make function2.test-json
	make function3.test-json

%.test-json:
	${l} tests/$*.json tests/$*.lines
	diff tests/$*.baseline tests/$*.lines

clean:
	rm -f *.hi
	rm -f *.o
	rm -f Locator
	rm -f tests/*.lines
