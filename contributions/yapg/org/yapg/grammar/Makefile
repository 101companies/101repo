build: GrammarParser.class

GrammarParser.class: Grammar.g Makefile
	java -classpath ".:../../../antlr-3.2.jar" org.antlr.Tool Grammar.g
	cd ../../..; javac -classpath ".:antlr-3.2.jar" org/yapg/grammar/*.java
	
clean:
	rm -f *.class
	rm -f *.tokens
	rm -f *Lexer.java
	rm -f *Parser.java

bootstrap:	
	cd ../../..; java -classpath ".:antlr-3.2.jar" org.yapg.Main org/yapg/grammar org.yapg.grammar Grammar
	make build