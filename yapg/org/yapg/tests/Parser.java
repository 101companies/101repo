package org.yapg.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;
import org.yapg.company.CompanyLexer;
import org.yapg.company.CompanyParser;

public class Parser {

	private static String posSample =
		"inputs" + File.separator + "sample.Company";
	private static String negSample =
		"inputs" + File.separator + "nonSample.Company";
	
	private static void parse(String s) throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream(s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        parser.parseCompany();
        if (parser.error) throw new RecognitionException();
	}
	
	@Test
	public void testPositive() throws IOException, RecognitionException {
		parse(posSample);
	}
	
	@Test(expected=RecognitionException.class)
	public void tesNegative() throws IOException, RecognitionException {
		parse(negSample);
	}	
}
