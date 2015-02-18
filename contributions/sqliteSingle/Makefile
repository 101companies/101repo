
setup:
	sqlite3 -init src/setup.sql bin/company.db .exit
	
teardown:
	sqlite3 -init src/teardown.sql bin/company.db .exit
	
total:
	sqlite3 -init src/total.sql bin/company.db .exit
	
cut:
	sqlite3 -init src/cut.sql bin/company.db .exit
	
median:
	sqlite3 -init src/median.sql bin/company.db .exit
	
test:
	sqlite3 -init src/setup.sql bin/test.db .exit
	sqlite3 -init src/sampleCompany.sql bin/test.db .exit
	@echo "Testing Total"
	sqlite3 -init src/total.sql bin/test.db .exit
	@echo "Expected 399747"
	@echo "Testing Median"
	sqlite3 -init src/median.sql bin/test.db .exit
	@echo "Expected 12345"
	@echo "Testing Cut"
	sqlite3 -init src/cut.sql bin/test.db .exit
	sqlite3 -init src/total.sql bin/test.db .exit
	@echo "Expected 199873.5"
	sqlite3 -init src/teardown.sql bin/test.db .exit