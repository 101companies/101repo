package org.softlang.tests;

import org.softlang.company.*;
import org.softlang.features.*;
import org.softlang.util.MyConnection;
import org.softlang.util.ObjectFactory;
import org.softlang.util.PersistenceTool;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing the company scenarios. See the README.
 */
public class Basics {

	private MyConnection myConnection;
	private ObjectFactory factory;
	private PersistenceTool persistenceTool;
	private Company company;

	@Before
	public void init() {
		myConnection = new MyConnection("localhost", "test", 3306, "root", "");
		factory = new ObjectFactory(myConnection);
		persistenceTool = new PersistenceTool(myConnection);
		company = new Company("meganalysis");
		company.setObjectFactory(factory);
		company.load();
	}

	@Test
	public void testTotal() {
		double total = Total.total(company);
		assertEquals(399747, total, 0.0);
	}

	@Test
	public void testDepth() {
		int depth = Depth.depth(company);
		assertEquals(3, depth);
	}

	@Test
	public void testCut() {
		double preCutTotal = Total.total(company);
		Cut.cutCompany(company);
		// persist and reload company
		persistenceTool.persistCompany(company);
		double newTotal = Total.total(factory.loadCompany(new Company(
				"meganalysis")));
		assertEquals(preCutTotal / 2, newTotal, 0.0);
	}
}
