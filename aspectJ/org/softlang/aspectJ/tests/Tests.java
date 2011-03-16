package org.softlang.aspectJ.tests;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.Company;
import static org.junit.Assert.*;

public class Tests {

	Company meganalysis;

	@Before
	public void setup() {
		meganalysis = SampleCompany.getSampleCompany();
	}

	@Test
	public void testTotal() {
		double total = meganalysis.total();
		assertEquals(399747.0, total, 0.0);
	}

	@Test
	public void testCut() {
		double preCutTotal = meganalysis.total();
		meganalysis.cut();
		double newTotal = meganalysis.total();
		assertEquals(preCutTotal / 2, newTotal, 0.0);
	}

}
