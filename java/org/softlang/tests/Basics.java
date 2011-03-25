package org.softlang.tests;

import org.softlang.basics.Company;

import static org.softlang.basics.Cut.*;
import static org.softlang.basics.Total.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Basics {
	
	@Test
	public void testTotal() {
		Company c = Company.readObject("sampleCompany.ser");
	    double total = total(c);		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() {
		Company c = Company.readObject("sampleCompany.ser");
		cut(c);
	    double total = total(c);		
	    assertEquals(199873.5, total, 0);
	}
}
