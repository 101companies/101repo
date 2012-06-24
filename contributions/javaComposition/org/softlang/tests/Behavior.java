package org.softlang.tests;

import org.softlang.model.Company;

import static org.softlang.qualities.Serialization.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Behavior {
	
	@Test
	public void testTotal() {
		Company c = deserializeCompany("sampleCompany.ser");
	    double total = c.total();		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() {
		Company c = deserializeCompany("sampleCompany.ser");
		c.cut();
	    double total = c.total();		
	    assertEquals(399747 / 2.0d, total, 0);
	}
}
