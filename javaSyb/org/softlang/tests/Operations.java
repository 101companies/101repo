package org.softlang.tests;

import org.softlang.company.Company;
import static org.softlang.features.Total.*;
import static org.softlang.features.Cut.*;
import static org.softlang.features.CutManagers.*;
import static org.softlang.features.Depth.*;
import static org.softlang.features.Serialization.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Operations {
	
	@Test
	public void testTotal() {
		Company c = readCompany("sampleCompany.ser");
	    double total = total(c);		
	    assertEquals(399747, total, 0);
	}
	
	@Test
	public void testCut() {
		Company c = readCompany("sampleCompany.ser");
	    double before = total(c);		
		cut(c);
	    double after = total(c);		
	    assertEquals(before / 2.0d, after, 0);
	}

	@Test
	public void testCutManagers() {
		Company c = readCompany("sampleCompany.ser");
		cutManagers(c);
	    double after = total(c);		
	    assertEquals(207835.0, after, 0);
	}
		
	@Test
	public void testDepth() {
		Company c = readCompany("sampleCompany.ser");
	    assertEquals(3, depth(c), 0);
	}	
}
