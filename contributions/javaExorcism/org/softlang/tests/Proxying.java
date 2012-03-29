package org.softlang.tests;

import org.softlang.company.*;
import org.softlang.company.factory.PojoFactory;
import org.softlang.features.*;
import org.softlang.proxy.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Proxying {
	
	@Test
	public void testTotal() {
		Company sampleCompany = Basics.createSampleCompany(new PojoFactory());
		AccessControl ac = new AccessControl();
		ac.disableWriteAcccess();
		sampleCompany = ac.deploy(sampleCompany);
		TotalReducer reducer = new TotalReducer();
	    assertEquals(399747, reducer.reduce(sampleCompany), 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTotalException() {
		Company sampleCompany = Basics.createSampleCompany(new PojoFactory());
		AccessControl ac = new AccessControl();
		ac.disableReadAcccess();
		sampleCompany = ac.deploy(sampleCompany);
		TotalReducer reducer = new TotalReducer();
	    reducer.reduce(sampleCompany);
	}
		
	@Test
	public void testCut() {
		Company sampleCompany = Basics.createSampleCompany(new PojoFactory());
		AccessControl ac = new AccessControl();
		sampleCompany = ac.deploy(sampleCompany);
		TotalReducer total = new TotalReducer();
		SimpleCut cut = new SimpleCut();
		double before = total.reduce(sampleCompany);
		cut.postorder(sampleCompany);
		double after = total.reduce(sampleCompany);
		assertEquals(before / 2.0d, after, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCutException() {
		Company sampleCompany = Basics.createSampleCompany(new PojoFactory());
		AccessControl ac = new AccessControl();
		ac.disableWriteAcccess();
		sampleCompany = ac.deploy(sampleCompany);
		SimpleCut cut = new SimpleCut();
		cut.postorder(sampleCompany);
	}	
}
