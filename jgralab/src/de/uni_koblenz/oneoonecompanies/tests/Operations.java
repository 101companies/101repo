package de.uni_koblenz.oneoonecompanies.tests;

import static org.junit.Assert.assertEquals;
import de.uni_koblenz.oneoonecompanies.CompanyServices;
import de.uni_koblenz.oneoonecompanies.schema.Company;
import org.junit.Test;
import org.junit.Before;

public class Operations {

	CompanyServices api;
	Company meganalysis;
	
	@Before
	public void setUpSample() {
		api = CompanyServices.instance();
		api.loadGraph("sampleCompany.tg");
		meganalysis = api.getCompany("meganalysis");
	}

	@Test
	public void testTotal() {
		long total = api.totalSalaries(meganalysis);
    	assertEquals(399747, total);
	}
	
	@Test
	public void testCut() {
		api.cutSalaries(meganalysis);
		long total = api.totalSalaries(meganalysis);
    	assertEquals(199875, total);
	}

	@Test
	public void testCutWithGReTL() {
		api.cutSalariesWithGReTL(meganalysis);
		long total = api.totalSalaries(meganalysis);
    	assertEquals(199875, total);
	}

	@Test
	public void testDepth() {
		int depth = api.depthOfDeptartmentStructure(meganalysis);
    	assertEquals(3, depth);		
	}
	
	@Test
	public void testAddMentorOk() {
		api.addMentor(meganalysis, "Ray", "Joe");
	}

//	@Test(expected=WHAT_EXCEPTION?.class)
//	public void testAddMentorNotOk() {
//		api.addMentor(meganalysis, "Ray", "Joe");
//		api.addMentor(meganalysis, "Craig", "Joe");
//	}	
	
}
