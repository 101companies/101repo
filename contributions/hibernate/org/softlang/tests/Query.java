package org.softlang.tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.softlang.company.Company;
import org.softlang.features.Persistence;
import org.softlang.features.Total;

// See online documentation for detailed instructions

public class Query {

	Persistence p = new Persistence();
	Company meganalysis;

	@Before
	public void loadCompany() {
		meganalysis = p.loadCompany("meganalysis");
	}

	@Test
	public void testTotal() {
		double total = Total.total(meganalysis);
		assertEquals(399747, total, 0.0);
	}
}
