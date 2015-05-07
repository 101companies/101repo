# The JAR to be built
jar = Wording.jar

#
# Make this empty if wsimport is in your path
# The sample here is Mac OS 10.5-specific.
#
java-prefix = /System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Commands/

none:

#
# Build JAR
#  To this end, we need to retrieve the WSDL from the running service.
#  In the following, we assume that the service is running locally.
#
build:
	rm -rf wsdl
	mkdir -p wsdl
	cd wsdl; ${java-prefix}wsimport http://localhost:8080/wcservice/Wording?wsdl -keep -s .
	${java-prefix}jar cvf ${jar} -C wsdl/ .
	mv ${jar} lib

purge:
	rm -rf wsdl
