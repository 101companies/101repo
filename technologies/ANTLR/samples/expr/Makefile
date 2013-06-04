CLASSPATH = -classpath ".:..:../../antlr-3.2.jar"

all: run-diff

run-diff: output.txt baseline.txt
	diff output.txt baseline.txt

output.txt: Test.class Makefile
	java ${CLASSPATH} expr.Test < input.txt > output.txt

Test.class: Test.java ExprLexer.java ExprParser.java Makefile
	javac ${CLASSPATH} Test.java ExprLexer.java ExprParser.java

ExprLexer.java ExprParser.java: Expr.g Makefile
	java ${CLASSPATH} org.antlr.Tool Expr.g

clean:
	rm -f *~
	rm -f *.class
	rm -f *.tokens
	rm -f *Lexer.java
	rm -f *Parser.java
	rm -f *__.g
	rm -f output.txt
