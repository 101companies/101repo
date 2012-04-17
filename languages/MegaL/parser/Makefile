geshi = php ../../../technologies/geshi/run.php
parse = java ${CLASSPATH} megal.parser.Main
antlr = ../../../technologies/ANTLR/antlr-3.2.jar

run: build

build:
	@cd megal/parser; make build -s

clean:
	@cd megal/parser; make clean -s

%.parse: build
	@echo Parsing $*
	@java -cp .:${antlr} megal.parser.Main $*
