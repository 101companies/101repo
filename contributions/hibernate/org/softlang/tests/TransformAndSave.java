package org.softlang.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.softlang.features.Cut;
import org.softlang.features.Total;

// See online documentation for detailed instructions

public class TransformAndSave extends Load {

	@Test
	public void testPersistence() {

		// Load for the first time
		load();
		
		// Cut first department
		Cut.cut(sampleCompany.getDepts().iterator().next());
		double total1 = Total.total(sampleCompany);

		// Save and reload
		manager.saveCompany(sampleCompany);
		load();

		// Check that save succeeded
		double total2 = Total.total(sampleCompany);
		assertEquals(total1, total2, 0.0);
	}

}
