package org.softlang.tests;

import org.softlang.company.*;
import org.softlang.company.factory.*;
import org.softlang.features.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test/demonstrate basic operations for totaling and cutting salaries.
 */
public class Basics {
	
	static Company createSampleCompany(Factory f) {
		
		// Create company
		Company sampleCompany = f.mkCompany();
		sampleCompany.setName("meganalysis");
		
		// Create all employees
		Employee craig = f.mkEmployee();
		craig.setName("Craig");
		craig.setAddress("Redmond");
		craig.setSalary(123456);
		craig.setManager(true);

		Employee erik = f.mkEmployee();
		erik.setName("Erik");
		erik.setAddress("Utrecht");
		erik.setSalary(12345);

		Employee ralf = f.mkEmployee();
		ralf.setName("Ralf");
		ralf.setAddress("Koblenz");
		ralf.setSalary(1234);		

		Employee ray = f.mkEmployee();
		ray.setName("Ray");
		ray.setAddress("Redmond");
		ray.setSalary(234567);
		ray.setManager(true);

		Employee klaus = f.mkEmployee();
		klaus.setName("Klaus");
		klaus.setAddress("Boston");
		klaus.setSalary(23456);
		klaus.setManager(true);
		
		Employee karl = f.mkEmployee();
		karl.setName("Karl");
		karl.setAddress("Riga");
		karl.setSalary(2345);
		karl.setManager(true);
		
		Employee joe = f.mkEmployee();
		joe.setName("Joe");
		joe.setAddress("Wifi City");
		joe.setSalary(2344);								

		// Create research department
		Department research = f.mkDepartment();
		research.setName("Research");
		research.add(craig);
		research.add(erik);
		research.add(ralf);
		sampleCompany.add(research);

		// Create development department
		Department development = f.mkDepartment();
		development.setName("Development");
		development.add(ray);
		sampleCompany.add(development);

		// Create sub-department dev1
		Department dev1 = f.mkDepartment();
		dev1.setName("Dev1");
		dev1.add(klaus);
		development.add(dev1);

		// Create sub-department dev11
		Department dev11 = f.mkDepartment();
		dev11.setName("Dev1.1");
		dev11.add(karl);
		dev11.add(joe);
		dev1.add(dev11);
		
		return sampleCompany;
	}
	
	private void testTotal(Factory f) {
		Company sampleCompany = createSampleCompany(f);
		TotalReducer reducer = new TotalReducer();
	    assertEquals(399747, reducer.reduce(sampleCompany), 0);
		TotalWalker walker = new TotalWalker();
		walker.preorder(sampleCompany);
	    assertEquals(399747, walker.getTotal(), 0);
	}

	@Test
	public void testTotalPojo() {
		testTotal(new PojoFactory());
	}
	
	@Test
	public void testTotalBean() {
		testTotal(new BeanFactory());
	}
	
	private void testCut(Factory f) {
		Company sampleCompany = createSampleCompany(f);	
		TotalReducer total = new TotalReducer();
		SimpleCut cut = new SimpleCut();
		double before = total.reduce(sampleCompany);
		cut.postorder(sampleCompany);
		double after = total.reduce(sampleCompany);
		assertEquals(before / 2.0d, after, 0);
	}
	
	@Test
	public void testCutPojo() {
		testCut(new PojoFactory());
	}
	
	@Test
	public void testCutBean() {
		testCut(new BeanFactory());
	}	
}
