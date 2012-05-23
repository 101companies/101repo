package org.softlang.tests;

import company.Company;
import static org.softlang.features.Serialization.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Operations {

	public Company sampleCompany;

	@Before
	public void setUp() throws IOException {
		sampleCompany = loadCompany("sampleCompany");
	}
	
	@Test 
	public void testTotal() {
		double total = sampleCompany.total();
		assertEquals(399747, total, 0.0);
	}

	@Test 
	public void testCut() {
		sampleCompany.cut();
		double total = sampleCompany.total();
		assertEquals(399747 / 2.0d, total, 0.0);
	}
}
