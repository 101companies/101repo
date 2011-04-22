package org.softlang.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;
import org.softlang.antlr.CompanyLexer;
import org.softlang.antlr.CompanyParser;

public class Parsing {
		
	private static void parseCompany(String s) throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream("inputs" + File.separatorChar + s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        parser.company();
        if (parser.error) throw new RecognitionException();
	}
	
	@Test
	public void testPositive() throws IOException, RecognitionException {
		parseCompany("sample.Company");
	}
	
	@Test(expected=RecognitionException.class)
	public void tesNegative() throws IOException, RecognitionException {
		parseCompany("nonSample.Company");
	}	
}
