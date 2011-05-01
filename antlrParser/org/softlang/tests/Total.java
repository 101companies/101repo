package org.softlang.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;
import org.softlang.parser.CompanyLexer;
import org.softlang.parser.CompanyParser;

public class Total {
		
	private static double total(String s) throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream("inputs" + File.separatorChar + s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        parser.company();
        if (parser.error) throw new RecognitionException();
        return parser.total;
	}
	
	@Test
	public void testPositive() throws IOException, RecognitionException {
		double total = total("sample.Company");
	    assertEquals(399747, total, 0);
	}
	
	@Test(expected=RecognitionException.class)
	public void tesNegative() throws IOException, RecognitionException {
		total("nonSample.Company");
	}	
}
