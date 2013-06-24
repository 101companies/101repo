package org.softlang.tests;

import org.junit.Test;
import static org.softlang.features.Total.*;
import static org.softlang.features.Depth.*;
import static org.junit.Assert.*;

/**
 * Test queries on company.
 */
public class Query extends Connect {

	/**
	 * This test will fail once Transform.testCut was performed.
	 */
	@Test
	public void testTotal() {
		connect();
		double total = total(connection, companyName);
		assertEquals(399747, total, 0.0);
	}

	/**
	 * This test should succeed even when Transform.testCut was performed.
	 */
	@Test
	public void testDepth() {
		connect();
		int depth = depth(connection, companyName);
		assertEquals(3, depth);
	}

}
