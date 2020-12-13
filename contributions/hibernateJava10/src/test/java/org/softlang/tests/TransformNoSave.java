package org.softlang.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.softlang.features.Cut;
import org.softlang.features.Total;

// See online documentation for detailed instructions

public class TransformNoSave extends Load {

	@Test
	public void testCut() {
		load();
		double total1 = Total.total(sampleCompany);
		Cut.cut(sampleCompany);
		double total2 = Total.total(sampleCompany);
		assertEquals(total1 / 2.0, total2);
	}
}