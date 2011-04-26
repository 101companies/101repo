package org.softlang.tests;

import org.softlang.company.Company;
import org.softlang.features.*;
import static org.softlang.features.Serialization.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Basics {
		
	@Test
	public void testTotal() {
		Company c = readCompany("sampleCompany.ser");
	    double total = c.accept(new Total());		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() {
		Company c = readCompany("sampleCompany.ser");
		c.accept(new Cut());
	    double total = c.accept(new Total());		
	    assertEquals(399747 / 2.0d, total, 0);
	}
}
