build:
	ghc HsFragmentLocator

test: build
	make type/MyType.test

%.test:
	./HsFragmentLocator $* < tests/Test.hs > log
	diff tests/$*.baseline log
	rm -f log

clean:
	rm -f log HsFragmentLocator *.o *.hi
