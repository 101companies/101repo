package org.softlang.java.tests;

import org.softlang.company.Company;
import static org.softlang.java.Total.*;
import static org.softlang.java.Cut.*;
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
