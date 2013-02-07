build:
	make locator/XmlFragmentLocator.class

locator/XmlFragmentLocator.class: locator/*.java Makefile
	javac locator/*.java

test: 
	./locator.py Company.xsd fragment.xpath lines.json
	diff baseline.json lines.json

othertest: 
	./locator.py Company.xsd /xs:schema/xs:element		

clean: 
	rm -f locator/*.class
	rm -f lines.json
