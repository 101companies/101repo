package org.softlang.tests;

import org.softlang.company.Company;
import static org.softlang.features.Serialization.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Basics {
	
	@Test
	public void testTotal() {
		Company c = readObject("sampleCompany.ser");
	    double total = c.total();		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() {
		Company c = readObject("sampleCompany.ser");
		c.cut();
	    double total = c.total();		
	    assertEquals(399747 / 2.0d, total, 0);
	}
}
