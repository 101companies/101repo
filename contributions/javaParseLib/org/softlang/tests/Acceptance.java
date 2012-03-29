package org.softlang.tests;

import org.softlang.parser.CompanyAcceptor;
import parseLib.util.Input;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test acceptor for companies
 */
public class Acceptance {

	private Input sampleCompany;
	private Input nonSampleCompany;	
	
	@Before
	public void prepare() throws FileNotFoundException, IOException {
		sampleCompany= 
			new Input(
				new FileReader( "inputs" + File.separator + "sample.Company" ));		
		nonSampleCompany= 
			new Input(
				new FileReader( "inputs" + File.separator + "nonSample.Company" ));		
	}
	
	/**
	 * Positive test case
	 */
	@Test
	public void testPositive() {
		assertTrue(new CompanyAcceptor().accept(sampleCompany));
	}

	/**
	 * Negative test case
	 */
	@Test
	public void testNegative() {
		assertFalse(new CompanyAcceptor().accept(nonSampleCompany));
	}		
}
