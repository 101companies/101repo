package org.yapg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.yapg.grammar.Grammar;
import org.yapg.grammar.GrammarLexer;
import org.yapg.grammar.GrammarParser;

/**
 * CLI access to YAPG
 */
public class Main {
	
	public static void main(String[] args) throws IOException, RecognitionException {
		String path = args[0];
		String pkg = args[1];
		String stem = args[2];
		FileInputStream stream = new FileInputStream(path + File.separatorChar + stem + ".yapg");
		ANTLRInputStream antlr = new ANTLRInputStream(stream);
		GrammarLexer lexer = new GrammarLexer(antlr);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);
		Grammar g = parser.parseGrammar();
		if (parser.error) throw new RecognitionException();
		Generator.generate(path, pkg, stem, g);
	}
}