package de.uni_koblenz.oneoonecompanies.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.uni_koblenz.oneoonecompanies.CompanyServices;
import de.uni_koblenz.oneoonecompanies.schema.Company;

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
		double total = api.totalSalaries(meganalysis);
		assertEquals(399747, total, 0.01);
	}

	@Test
	public void testCut() {
		api.cutSalaries(meganalysis);
		double total = api.totalSalaries(meganalysis);
		assertEquals(199873.5, total, 0.01);
	}

	@Test
	public void testCutWithGReTL() {
		api.cutSalariesWithGReTL(meganalysis);
		double total = api.totalSalaries(meganalysis);
		assertEquals(199873.5, total, 0.01);
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

	@Test(expected = RuntimeException.class)
	public void testAddMentorNotOk() {
		api.addMentor(meganalysis, "Ray", "Joe");
		api.addMentor(meganalysis, "Craig", "Joe");
	}

}
