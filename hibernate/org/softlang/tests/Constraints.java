package org.softlang.tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.softlang.company.Company;
import org.softlang.features.Persistence;
import org.softlang.features.Mentoring;

// See README for detailed usage instructions

public class Constraints {

	@Test
	public void test() {
		Company c = new Persistence().loadCompany("meganalysis");
		assertTrue(Mentoring.check(c));
	}
}
