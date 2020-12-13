package org.softlang.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.softlang.features.Cut;
import org.softlang.features.Total;

// See online documentation for detailed instructions

public class TransformAndSave extends Load {

	@Test
	public void testPersistence() {

		// Load for the first time
		load();

		// Cut all salaries
		Cut.cut(sampleCompany);
		double total1 = Total.total(sampleCompany);

		// Save and reload
		manager.saveCompany(sampleCompany);
		load();

		// Check that save succeeded
		double total2 = Total.total(sampleCompany);
		assertEquals(total1, total2);
	}

}