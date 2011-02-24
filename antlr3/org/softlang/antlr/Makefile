CLASSPATH = -classpath ".:../../../../library/antlr/antlr-3.2.jar"

generate:
	java ${CLASSPATH} org.antlr.Tool Company.g

clean:
	rm -f *.class
	rm -f *.tokens
	rm -f *Lexer.java
	rm -f *Parser.java
