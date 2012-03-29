GHCIDPH = C:/ghc/ghc72/bin/ghci
GHCDPH = C:/ghc/ghc72/bin/ghc

test: 
	$(GHCDPH) -c -Odph -fdph-seq Company.hs
	$(GHCDPH) -c -Odph -fdph-seq SampleCompany.hs
	$(GHCDPH) -c -Odph -fdph-seq SalaryFlattener.hs
	$(GHCDPH) -c -Odph -fdph-seq TotalV.hs
	$(GHCDPH) -c -Odph -fdph-seq CutV.hs
	$(GHCDPH) -c -Odph -fdph-seq Total.hs
	$(GHCDPH) -c -Odph -fdph-seq Cut.hs
	$(GHCDPH) -c -Odph -fdph-seq Main.hs
	echo "main" | $(GHCIDPH) -v0 -fdph-seq Main.hs > log 
	diff log baseline

clean:
	rm -f log
	rm -f *.o
	rm -f *.hi
