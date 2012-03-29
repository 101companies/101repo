package org.softlang.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;
import org.softlang.parser.CompanyLexer;
import org.softlang.parser.CompanyParser;

public class Parsing {
		
	private static String posSample =
		"inputs" + File.separator + "sample.Company";
	private static String negSample =
		"inputs" + File.separator + "nonSample.Company";
		
	private static void acceptCompany(String s) throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream(s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        parser.company();
        if (parser.error) throw new RecognitionException();
	}
	
	@Test
	public void testPositive() throws IOException, RecognitionException {
		acceptCompany(posSample);
	}
	
	@Test(expected=RecognitionException.class)
	public void tesNegative() throws IOException, RecognitionException {
		acceptCompany(negSample);
	}	
}
