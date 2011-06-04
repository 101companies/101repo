package org.softlang.tests;

import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.company.factory.BeanFactory;
import org.softlang.features.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 * Test cases related to observability
 */
public class Observability {

	private CompanyImpl sampleCompany;

	@Before
	public void createSampleCompany() {
		sampleCompany = (CompanyImpl)Basics.createSampleCompany(new BeanFactory());
	}

	/**
	 * Test Logging feature
	 */
	@Test
	public void testLogging() {
		Logging log = new Logging();
		((CompanyImpl)sampleCompany).addObserver(log);
		SimpleCut cut = new SimpleCut();
		cut.postorder(sampleCompany);
		assertEquals(7, log.getSize());		
	}
	
	/**
	 * Test Precedence feature
	 */
	@Test
	public void testPrecedence() {
		Precedence prec = new Precedence();
		((CompanyImpl)sampleCompany).addObserver(prec);
		OrderedCut cut = new OrderedCut();
		cut.postorder(sampleCompany);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void testPrecedenceException() {
		Precedence prec = new Precedence();
		((CompanyImpl)sampleCompany).addObserver(prec);
		SimpleCut cut = new SimpleCut();
		cut.postorder(sampleCompany);
	}	
}
