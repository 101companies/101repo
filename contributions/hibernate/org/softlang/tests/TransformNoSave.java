package org.softlang.tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.softlang.company.Company;
import org.softlang.features.Cut;
import org.softlang.features.Persistence;
import org.softlang.features.Total;

// See online documentation for detailed instructions

public class TransformNoSave {

	Persistence p = new Persistence();
	Company meganalysis;

	@Before
	public void loadCompany() {
		meganalysis = p.loadCompany("meganalysis");
	}

	@Test
	public void testCut() {
		double total1 = Total.total(meganalysis);
		Cut.cut(meganalysis);
		double total2 = Total.total(meganalysis);
		assertEquals(total1 / 2.0, total2, 0.0);
	}
}
