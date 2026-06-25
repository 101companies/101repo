package org.softlang.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.softlang.features.Mentoring;

// See online documentation for detailed instructions

public class Check extends Load {

	@Test
	public void test() {
		load();
		assertTrue(Mentoring.check(sampleCompany));
	}
}