package org.softlang.tests;

import org.softlang.company.*;
import org.softlang.util.MyConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing the company scenarios.
 * See the README. 
 */
public class Persistence {

	MyConnection myConnection =
		new MyConnection(
				"localhost",
				"company",
				3306,
				"root", "");

	private ObjectFactory factory = new ObjectFactory(myConnection);
	private PersistenceTool persistenceTool = new PersistenceTool(myConnection);

	@Test
	public void testPersistency() throws FileNotFoundException, IOException,
			ClassNotFoundException {

		// add a new small testing department
		Company company = factory.createCompany();
		Dept testing = new Dept();
		testing.setName("Testing");

		Employee ross = new Employee();
		ross.setName("Ross");
		ross.setAddress("London");
		ross.setSalary(34567.0);
		testing.setManager(ross);
		testing.getEmployees().add(ross);

		Dept testing1 = new Dept();
		testing1.setName("Testing1");
		Employee dan = new Employee();
		dan.setName("Dan");
		dan.setAddress("New York");
		dan.setSalary(4567.0);
		testing1.setManager(dan);
		testing1.getEmployees().add(dan);
		Employee bob = new Employee();
		bob.setName("Bob");
		bob.setAddress("Chicago");
		bob.setSalary(4566.0);
		testing1.getEmployees().add(bob);

		testing.getSubDepartments().add(testing1);
		company.getDepts().add(testing);

		// persist, reload, and compare
		persistenceTool.persistCompany(company);
		Company loadedCompany = factory.createCompany();
		assertTrue(company.equals(loadedCompany));
	}
}
