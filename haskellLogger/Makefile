test:
	echo "main" | ghci -v0 Main.hs > log
	diff log baseline
	rm log

clean:
	rm -f log
