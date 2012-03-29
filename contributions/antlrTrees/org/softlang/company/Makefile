CLASSPATH = -classpath ".:../../../antlr-3.2.jar"

generate:
	java ${CLASSPATH} org.antlr.Tool Company.g
	java ${CLASSPATH} org.antlr.Tool Total.g
	java ${CLASSPATH} org.antlr.Tool Cut.g

clean:
	rm -f *.class
	rm -f *.tokens
	rm -f *Lexer.java
	rm -f *Parser.java
