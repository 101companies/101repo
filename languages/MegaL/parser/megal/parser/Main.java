package megal.parser;

import java.io.File;
import java.io.FileInputStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

public class Main {

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input =
	    new ANTLRInputStream(
	       new FileInputStream(
                  new File(args[0])));
        MegaLLexer lexer = new MegaLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MegaLParser parser = new MegaLParser(tokens);
        parser.megal();
    }
}