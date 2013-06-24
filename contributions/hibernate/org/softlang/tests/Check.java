package org.softlang.tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.softlang.company.Company;
import org.softlang.features.Persistence;
import org.softlang.features.Mentoring;

// See online documentation for detailed instructions

public class Check {

	@Test
	public void test() {
		Company c = new Persistence().loadCompany("meganalysis");
		assertTrue(Mentoring.check(c));
	}
}
