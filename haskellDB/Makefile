test:
	dbdirect-hdbc-odbc "DBDesc" "DBDesc" "Driver=MySQL ODBC 5.1 Driver;Port=3306;Server=localhost;User=root;Database=101companies"
	ghc DBDesc
	echo "main" | ghci -v0 Main.hs > log
	diff log baseline
	rm log
	
clean:
	rm -f log
	rm -f DBDesc.*
	rm -r DBDesc