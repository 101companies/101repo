package org.softlang.antlr;

import org.softlang.company.Company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class Tests {
		
	private static String sampleCompany =
		  ".." + File.separator
		+ "antlr" + File.separator
		+ "sample.Company";

	private Company c;
	
	@Before
	public void testParse() throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream(sampleCompany);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        c = parser.company();
	}		
	
	@Test
	public void testTotal() {
		double total = c.total();
	    assertEquals(399747, total, 0);
	}	    
	    
	@Test
	public void testCut()  {
	    c.cut();
	    Double total = c.total();
	    assertEquals(199873.5, total, 0);
	}	
}
