build: Matcher

Matcher: *.hs Makefile
	@ghc Matcher.hs

test: Matcher
	@make HXT.test

HXT.test:
	@./matcher.py \
		../../contributions/hxt/Total.hs \
		"Text.XML.HXT"

clean:
	rm -f *.hi
	rm -f *.o
	rm -f Matcher
