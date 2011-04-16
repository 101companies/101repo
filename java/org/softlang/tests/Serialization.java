package org.softlang.tests;

import java.lang.reflect.Field;
import java.util.LinkedList;

import org.softlang.company.*;

import static org.softlang.features.Serialization.*;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * We do a round-trip test for de-/serialization.
 * That is, first, we create an object in memory.
 * Then, we write (say, serialize) the object.
 * Then, we read (say, de-serialize) the object.
 * Finally, we compare original and read object for structural equality.
 */
public class Serialization {

	public static Company createCompany() {
		
		// Create company
		Company company = new Company();
		company.setName("meganalysis");
		
		// Create all employees
		Employee craig = new Employee();
		craig.setName("Craig");
		craig.setAddress("Redmond");
		craig.setSalary(123456);
		Employee erik = new Employee();
		erik.setName("Erik");
		erik.setAddress("Utrecht");
		erik.setSalary(12345);
		Employee ralf = new Employee();
		ralf.setName("Ralf");
		ralf.setAddress("Koblenz");
		ralf.setSalary(1234);		
		Employee ray = new Employee();
		ray.setName("Ray");
		ray.setAddress("Redmond");
		ray.setSalary(234567);
		Employee klaus = new Employee();
		klaus.setName("Klaus");
		klaus.setAddress("Boston");
		klaus.setSalary(23456);
		Employee karl = new Employee();
		karl.setName("Karl");
		karl.setAddress("Riga");
		karl.setSalary(2345);
		Employee joe = new Employee();
		joe.setName("Joe");
		joe.setAddress("Wifi City");
		joe.setSalary(2344);								

		// Create research department
		Department research = new Department();
		research.setManager(craig);
		research.setName("Research");
		research.getEmployees().add(erik);
		research.getEmployees().add(ralf);
		company.getDepts().add(research);

		// Create development department
		Department development = new Department();
		development.setManager(ray);
		development.setName("Development");
		company.getDepts().add(development);

		// Create sub-department dev1
		Department dev1 = new Department();
		development.getSubdepts().add(dev1);
		dev1.setName("Dev1");
		dev1.setManager(klaus);

		// Create sub-department dev11
		Department dev11 = new Department();
		dev1.getSubdepts().add(dev11);
		dev11.setName("Dev1.1");
		dev11.setManager(karl);
		dev11.getEmployees().add(joe);

		return company;
	}

	@Test
	public void testLoadAndCreate() {
		Company sampleCompany = createCompany(); 
		writeCompany(sampleCompany, "sampleCompany.ser");
		Company loadedCompany = readCompany("sampleCompany.ser");
		assertTrue(org.softlang.features.Serialization.structurallyEqual(sampleCompany, loadedCompany));
	}
	
}
