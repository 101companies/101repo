package org.softlang.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.softlang.features.Total;

// See online documentation for detailed instructions

public class Query extends Load {

	@Test
	public void testTotal() {
		load();
		double total = Total.total(sampleCompany);
		assertEquals(399747, total, 0.0);
	}
}
