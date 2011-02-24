test:
	echo "main" | ghci -v0 -i.:../alpha Demo.hs > log
	diff log baseline
	rm log

clean:
	rm -f log
