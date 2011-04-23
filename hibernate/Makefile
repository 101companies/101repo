#
# Use of the Makefile is optional.
# This distribution works fine just with Eclipse.
# See the README
#

none:

###################################################################
# Start HSQL DB server

start-db:
	mkdir -p data
	cd data; java -cp ../lib/hsqldb.jar org.hsqldb.Server &


###################################################################
# Start GUI of HSQLDB
# This allows several things:
#  - Observe the relational schema of the persistent classes
#  - Shut down the database server

start-gui:
	@echo "Remember: Select 'HSQL Database Engine Server'!"
	java -cp lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing &


###################################################################
# Remove/replace all files so that we get a clean setup

clean:
	rm -f *~
	rm -f data/*
