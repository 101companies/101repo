package org.softlang.tests;

import org.junit.Before;
import org.junit.Test;
import org.softlang.features.Cut;
import org.softlang.features.Depth;
import org.softlang.features.Total;
import org.softlang.util.MyConnection;

import static org.junit.Assert.*;

/**
 * Testing the company scenarios.
 */
public class Basics {

	MyConnection myConnection;
	String companyName;

	@Before
	public void connect() {
		myConnection = new MyConnection("localhost", "test", 3306, "root", "");
		myConnection.connect();
		companyName = "meganalysis";
	}

	@Test
	public void testTotal() {

		double total = Total.total(myConnection, companyName);
		assertEquals(399747, total, 0.0);
	}

	@Test
	public void testCut() {

		Cut.cut(myConnection, "meganalysis");
		double total = Total.total(myConnection, companyName);
		assertEquals(399747 / 2.0d, total, 0.0);
	}

	@Test
	public void testDepth() {

		int depth = Depth.depth(myConnection, companyName);
		assertEquals(3, depth);
	}

}
