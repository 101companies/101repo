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
	cd data; java -cp ../../library/hibernate/hsqldb.jar org.hsqldb.Server &


###################################################################
# Start GUI of HSQLDB
# This allows several things:
#  - Observe the relational schema of the persistent classes
#  - Shut down the database server

start-gui:
	@echo "Remember: Select 'HSQL Database Engine Server'!"
	java -cp ../library/hibernate/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing &

###################################################################
# Change Hibernate configuration post table creation

state2:
	cp hibernate.cfg.xml.state2 hibernate.cfg.xml


###################################################################
# Remove/replace all files so that we get a clean setup

clean:
	rm -f *~
	rm -f data/*
	cp hibernate.cfg.xml.state1 hibernate.cfg.xml
