i = -i.:../haskellVariation

test:
	echo "main" | ghci -v0 ${i} Main.hs > log
	diff log baseline
	rm log

clean:
	rm -f log
