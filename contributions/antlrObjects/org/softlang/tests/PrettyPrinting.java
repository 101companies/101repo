package org.softlang.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import org.softlang.company.Company;
import static org.softlang.parser.CompanyParser.*;
import org.softlang.pp.PpCompany;
import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;

public class PrettyPrinting {

	private static String sampleCompany =
		"inputs" + File.separator + "sample.Company";	
	
	private static String output =
		"output.txt";
	
	@Test
	public void testPp() throws IOException, RecognitionException {
		Company c = parse(sampleCompany);
		c.cut();
		PpCompany p = new PpCompany();
		p.ppCompany(c,output);
		c = parse(output);
	    double total = c.total();		
	    assertEquals(399747 / 2.0d, total, 0);
	}
}
