package org.softlang.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.softlang.action.CutAction;
import org.softlang.action.TotalAction;
import org.softlang.company.Company;
import org.softlang.context.CompanyContextManager;
import org.softlang.context.ConcurrentContext;

public class Threads {

	@Test
	public void total() {
		Company c1 = CompanyCreator.createCompany();

		Double t1 = CompanyContextManager.execute(new ConcurrentContext(), c1,
				new TotalAction());

		assertEquals(c1.total(), t1);
	}

	@Test
	public void cut() {
		Company c1 = CompanyCreator.createCompany();
		Company c2 = CompanyCreator.createCompany();

		// Precondition
		assertEquals(c1.total(), c2.total());

		// Sequential cut
		c1.cut();

		// Concurrent cut
		CompanyContextManager.execute(new ConcurrentContext(), c2,
				new CutAction());
		
		// Postcondition
		assertEquals(c1.total(), c2.total());
	}
}
