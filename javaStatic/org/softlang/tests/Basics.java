package org.softlang.tests;

import org.softlang.company.Company;
import static org.softlang.features.Total.*;
import static org.softlang.features.Cut.*;
import static org.softlang.features.Serialization.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Basics {
	
	@Test
	public void testTotal() {
		Company c = readCompany("sampleCompany.ser");
	    double total = total(c);		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() {
		Company c = readCompany("sampleCompany.ser");
		cut(c);
	    double total = total(c);		
	    assertEquals(399747 / 2.0d, total, 0);
	}
}
