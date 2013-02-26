build:
	ghc HsFactExtractor.hs

test: build
	make Test.test

%.test:
	./HsFactExtractor < tests/$*.hs > log
	diff tests/$*.baseline log
	rm -f log

# Operational documentation of test data's origin
copy:
	cp ../../../101haskell/contributions/haskellStarter/*.hs tests/haskellStarter
	cp ../../../101haskell/contributions/haskellData/*.hs tests/haskellData

clean:
	rm -f log HsFactExtractor *.o *.hi

