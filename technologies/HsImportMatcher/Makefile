build: Matcher

Matcher: *.hs Makefile
	@ghc Matcher.hs

test: Matcher
	@make HXT.test

HXT.test:
	@./matcher.py \
		tests/hxt/Total.hs \
		"Text.XML.HXT"

# Copy to fetch a new version for test data
copy:
	cp ../../../101haskell/contributions/hxt/Total.hs tests/hxt

clean:
	rm -f *.hi
	rm -f *.o
	rm -f Matcher
