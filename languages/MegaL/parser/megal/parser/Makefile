antlr = ../../../technologies/ANTLR/antlr-3.2.jar

build: Main.class

Main.class: MegaL.tokens *.java
	cd ../..; \
	javac \
	-cp ".:${antlr}" \
	megal/parser/Main.java

MegaL.tokens: MegaL.g
	java \
	-cp ".:../../${antlr}" \
	org.antlr.Tool \
	MegaL.g

clean:
	rm -f *.class
	rm -f *.tokens
	rm -f *Lexer.java
	rm -f *Parser.java
