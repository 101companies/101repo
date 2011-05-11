package org.softlang.tests;

import org.softlang.company.*;
import org.softlang.util.MyConnection;
import org.softlang.util.ObjectFactory;
import org.softlang.util.PersistenceTool;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing the company scenarios. See the README.
 */
public class Persistence {

	private MyConnection myConnection;
	private ObjectFactory factory;
	private PersistenceTool persistenceTool;
	private Company company;

	@Before
	public void init() {
		myConnection = new MyConnection("localhost", "test", 3306, "root", "");
		factory = new ObjectFactory(myConnection);
		persistenceTool = new PersistenceTool(myConnection);
		company = new Company("meganalysis");
		company.setObjectFactory(factory);
		company.load();
	}

	@Test
	public void testPersistencyManipulate() {

		// add a new small testing department
		Department testing = new Department();
		testing.setName("Testing");

		Employee ross = new Employee();
		ross.setName("Ross");
		ross.setAddress("London");
		ross.setSalary(34567.0);
		testing.setManager(ross);

		Department testing1 = new Department();
		testing1.setName("Testing1");
		Employee dan = new Employee();
		dan.setName("Dan");
		dan.setAddress("New York");
		dan.setSalary(4567.0);
		testing1.setManager(dan);
		Employee bob = new Employee();
		bob.setName("Bob");
		bob.setAddress("Chicago");
		bob.setSalary(4566.0);
		testing1.getEmployees().add(bob);

		testing.getSubDepartments().add(testing1);
		company.getDepts().add(testing);

		// persist, reload, and compare
		persistenceTool.persistCompany(company);
		Company loadedCompany = factory.loadCompany(new Company("meganalysis"));
		assertTrue(company.equals(loadedCompany));
	}

	@Test
	public void testPersistencyNew() {

		// create a new company
		Company dunder = new Company("Dunder Mifflin");
		Department scranton = new Department();
		scranton.setName("Scranton Branch");

		Employee michael = new Employee();
		michael.setName("Michael");
		michael.setAddress("Main Street");
		michael.setSalary(654321.0);
		scranton.setManager(michael);

		Department accounting = new Department();
		accounting.setName("Accounting");
		Employee oscar = new Employee();
		oscar.setName("Oscar");
		oscar.setAddress("Greentree Street");
		oscar.setSalary(65432.0);
		accounting.setManager(oscar);

		Employee kevin = new Employee();
		kevin.setName("Kevin");
		kevin.setAddress("Ford Avenue");
		kevin.setSalary(6543.0);

		accounting.getEmployees().add(kevin);

		scranton.getSubDepartments().add(accounting);
		dunder.getDepts().add(scranton);
		

		// persist, reload, and compare
		persistenceTool.persistCompany(dunder);
		Company loadedDunder = factory.loadCompany(new Company("Dunder Mifflin"));
		assertTrue(dunder.equals(loadedDunder));

	}
}
