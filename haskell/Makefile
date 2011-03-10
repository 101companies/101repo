test:
	echo "main" | ghci -v0 Demo.hs > log
	diff log baseline
	rm log

clean:
	rm -f log
