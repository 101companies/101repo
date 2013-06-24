package org.softlang.tests;

import org.junit.Test;
import static org.softlang.features.Total.*;
import static org.softlang.features.Cut.*;
import static org.junit.Assert.*;

/**
 * Test transformation for salary cut on company.
 */
public class Transform extends Connect {

	@Test
	public void testCut() {
		connect();
		double total1 = total(connection, companyName);
		assert total1 > 0.0;
		cut(connection, companyName);
		double total2 = total(connection, companyName);
		assertEquals(total1 / 2.0d, total2, 0.0);
	}
}
