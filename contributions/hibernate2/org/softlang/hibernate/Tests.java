package org.softlang.hibernate;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.softlang.om.Company;

// See README for detailed usage instructions

public class Tests {

	Company meganalysis;
	HibernateConnectivity hc = new HibernateConnectivity();

	@Before
	public void loadCompany() {
		meganalysis = hc.loadCompany();
	}

	@Test
	public void testTotalAndCut() {
		// Test scenario "total"
		double oldTotal = Total.total(meganalysis);
		assertEquals(399747, oldTotal, 0.0);

		// Test scenario "cut"
		Cut.cut(meganalysis);
		double cutTotal = Total.total(meganalysis);
		assertEquals(oldTotal / 2, cutTotal, 0.0);

	}

	@Test
	public void testPersistence() {
		// Cut first department
		Cut.cut(meganalysis.getDepts().iterator().next());
		double total1 = Total.total(meganalysis);

		// Save and reload
		hc.saveCompany(meganalysis);
		meganalysis = hc.loadCompany();

		double total2 = Total.total(meganalysis);
		assertEquals(total1, total2, 0.0);

	}

}
