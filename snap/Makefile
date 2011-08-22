run:
	cabal install
	haskellSnap -p 8010

clean:
	rm -r dist
	rm -f log/access.log; rm -f log/errors.log
	touch log/access.log; touch log/errors.log