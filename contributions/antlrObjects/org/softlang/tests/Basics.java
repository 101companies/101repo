package org.softlang.tests;

import java.io.File;
import java.io.IOException;

import org.softlang.company.Company;

import static org.softlang.parser.CompanyParser.*;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import static org.junit.Assert.*;

public class Basics {

	private static String sampleCompany =
		"inputs" + File.separator + "sample.Company";	
	
	@Test
	public void testTotal() throws IOException, RecognitionException {
		Company c = parse(sampleCompany);
	    double total = c.total();		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() throws IOException, RecognitionException {
		Company c = parse(sampleCompany);
		c.cut();
	    double total = c.total();		
	    assertEquals(399747 / 2.0d, total, 0);
	}
}
