package org.softlang.tests;

import java.io.IOException;

import org.softlang.company.Company;

import static org.softlang.parser.CompanyParser.*;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import static org.junit.Assert.*;

public class Basics {
	
	@Test
	public void testTotal() throws IOException, RecognitionException {
		Company c = parse("sample.Company");
	    double total = c.total();		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() throws IOException, RecognitionException {
		Company c = parse("sample.Company");
		c.cut();
	    double total = c.total();		
	    assertEquals(199873.5, total, 0);
	}
}
