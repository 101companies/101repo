package org.softlang.tests;

import org.softlang.company.*;
import org.softlang.jdbc.*;
import org.softlang.util.MyConnection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing the company scenarios.
 * See the README. 
 */
public class Scenarios {

	MyConnection myConnection =
		new MyConnection(
				"localhost",
				"company",
				3306,
				"root", "");

	private ObjectFactory factory = new ObjectFactory(myConnection);
	private PersistenceTool persistenceTool = new PersistenceTool(myConnection);
	private Company company = factory.createCompany();

	@Test
	public void testTotal() throws SQLException {
		double total = Total.total(company);
		assertEquals(399747, total, 0.0);
	}

	@Test
	public void testCut() {
		double preCutTotal = Total.total(company);
		Cut.cutCompany(company);
		// persist and reload company
		persistenceTool.persistCompany(company);
		double newTotal = Total.total(factory.createCompany());
		assertEquals(preCutTotal / 2, newTotal, 0.0);
	}
}
