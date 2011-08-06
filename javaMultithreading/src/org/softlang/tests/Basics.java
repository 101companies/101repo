package org.softlang.tests;

import org.softlang.company.Company;
import org.junit.Test;
import static org.junit.Assert.*;

public class Basics {
	
	@Test
	public void testTotal() {
		Company c = CompanyCreator.createCompany();
		assertEquals(CompanyCreator.SALARY, c.total(), 0);
	}
	
	@Test
	public void testCut() {
		Company c = CompanyCreator.createCompany();
		c.cut();
		assertEquals(CompanyCreator.SALARY / 2.0d, c.total(), 0);
	}
}
