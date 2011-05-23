package org.softlang.tests;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.Company;
import static org.junit.Assert.*;

public class Tests {

	Company sampleCompany;

	@Before
	public void setup() {
		sampleCompany = SampleCompany.createSampleCompany();
	}

	@Test
	public void testTotal() {
		double total = sampleCompany.total();
		assertEquals(399747.0, total, 0.0);
	}

	@Test
	public void testCut() {
		double preCutTotal = sampleCompany.total();
		sampleCompany.cut();
		double newTotal = sampleCompany.total();
		assertEquals(preCutTotal / 2, newTotal, 0.0);
	}

	@Test
	public void testDepth() {
		assertEquals(3, sampleCompany.depth());
	}

}
