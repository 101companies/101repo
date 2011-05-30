create:
	sqlite3 test.db < input.txt
	
test:
	echo "main" | ghci -v0 Main.hs > log
	diff log baseline
	rm log
	
clean:
	rm -f log
	rm -f test.db
	