package org.softlang.tests;

import org.softlang.structure.Company;

import static org.softlang.quality.Serialization.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Behavior {
	
	@Test
	public void testTotal() {
		Company c = readCompany("sampleCompany.ser");
	    double total = c.total();		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() {
		Company c = readCompany("sampleCompany.ser");
		c.cut();
	    double total = c.total();		
	    assertEquals(399747 / 2.0d, total, 0);
	}
}
