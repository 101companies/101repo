build: Locator

Locator: *.hs Makefile
	ghc Locator.hs

test: Locator
	make data.test
	make function1.test
	make function2.test

%.test:
	./Locator tests/Test.hs tests/$*.json tests/$*.lines
	diff tests/$*.baseline tests/$*.lines

clean:
	rm -f *.hi
	rm -f *.o
	rm -f Locator
	rm -f tests/*.lines
