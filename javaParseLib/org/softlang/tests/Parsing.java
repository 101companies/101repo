package org.softlang.tests;

import org.softlang.parser.CompanyParser;
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
public class Parsing {

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
		assertEquals(new CompanyParser().parse(sampleCompany), 399747.0, 0);
	}

	/**
	 * Negative test case
	 */
	@Test
	public void testNegative() {
		assertEquals(new CompanyParser().parse(nonSampleCompany), null);
	}		
}
