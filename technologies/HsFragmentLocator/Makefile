build: cabal
	ghc HsFragmentLocator

test: build
	make type/MyType.test
	make data/MyData.test
	make newtype/MyNewtype.test
	make function/f.test
	make function/g.test
	make function/h.test
	make pattern/x.test
	make pattern/y.test
	make function/f1.test
	make function/f2.test

cabal:
	cabal install json

%.test:
	./HsFragmentLocator $* < tests/Test.hs > log
	diff tests/$*.baseline log
	rm -f log

clean:
	rm -f log HsFragmentLocator *.o *.hi
