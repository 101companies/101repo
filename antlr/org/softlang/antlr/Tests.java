package org.softlang.antlr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;

public class Tests {
		
	private static void parse(String s) throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream("inputs" + File.separatorChar + s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        parser.company();
	}
	
	@Test
	public void testPositive() throws IOException, RecognitionException {
		parse("sample.Company");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void tesNegative() throws IOException, RecognitionException {
		parse("nonSample.Company");
	}	
}
