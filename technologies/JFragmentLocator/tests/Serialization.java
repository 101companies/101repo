/*
My funny top comment 

even over multiple lines (it's an evil comment)
*/


package org.softlang.tests;

import org.softlang.model.Company;

import static org.softlang.behavior.Cut.*;
import static org.softlang.behavior.Total.*;
import static org.softlang.qualities.Serialization.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Behavior {
	private class Testclass {
		public Testclass() {
		}
		
		/* Test */
		@Test
		public String mymethod() {
		}
		
		public String mymethod(String a) {
		}
	}
	
	@Test
	public void testTotal() {
		Company c = deserializeCompany("sampleCompany.ser");
	    double total = total(c);		
	    assertEquals(399747, total, 0);
	}

	@Test
	public void testCut() {
		Company c = deserializeCompany("sampleCompany.ser");
		cut(c);
	    double total = total(c);		
	    assertEquals(399747 / 2.0d, total, 0);
	}
}