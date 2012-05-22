build:
	cd ../../..; java -classpath ".:antlr-3.2.jar" org.yapg.Main org/yapg/company org.yapg.company Company
	java -classpath ".:../../../antlr-3.2.jar" org.antlr.Tool Company.g
	cd ../../..; javac -classpath ".:antlr-3.2.jar" org/yapg/company/*.java

clean:
	rm -f *.class
	rm -f *.tokens
	rm -f *.java
	rm -f *.g
