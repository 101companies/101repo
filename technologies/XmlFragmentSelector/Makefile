generate: 
	javac locator/*.java

test:
	java locator/XMLFragmentSelector Company.xsd fragment.xpath lines.json
	diff -w baseline.json lines.json
		
clean:	
	rm locator/*.class
	rm lines.json
	
	
