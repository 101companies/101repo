package org.softlang.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;
import org.softlang.parser.Company;

public class Total {

	private static String posSample =
		"inputs" + File.separator + "sample.Company";
	private static String negSample =
		"inputs" + File.separator + "nonSample.Company";
		
	private static double total(String s) throws IOException {
		double total = 0;
		FileInputStream stream = new FileInputStream(s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        Company lexer = new Company(antlr);
        Token token;
        while ((token = lexer.nextToken())!=Token.EOF_TOKEN) 
        	if (token.getType()==Company.FLOAT)
        		total += Double.parseDouble(token.getText());
        return total;
	}
	
	@Test
	public void testPositive() throws IOException, RecognitionException {
		double total = total(posSample);
	    assertEquals(399747, total, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void tesNegative() throws IOException, RecognitionException {
		total(negSample);
	}	
}
