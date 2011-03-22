package org.softlang.aspectJ.tests;

import org.softlang.company.*;

public class SampleCompany {

	public static Company getSampleCompany() {
		
		// Create company
		Company company = new Company();
		company.setName("meganalysis");
		
		// Create all employees
		Employee craig = new Employee();
		craig.setName("Craig");
		craig.setSalary(123456);
		craig.setAddress("Redmond");
		Employee erik = new Employee();
		erik.setName("Erik");
		erik.setSalary(12345);
		erik.setAddress("Utrecht");
		Employee ralf = new Employee();
		ralf.setName("Ralf");
		ralf.setSalary(1234);		
		ralf.setAddress("Koblenz");
		Employee ray = new Employee();
		ray.setName("Ray");
		ray.setSalary(234567);
		ray.setAddress("Redmond");
		Employee klaus = new Employee();
		klaus.setName("Klaus");
		klaus.setSalary(23456);
		klaus.setAddress("Boston");
		Employee karl = new Employee();
		karl.setName("Karl");
		karl.setSalary(2345);
		karl.setAddress("Riga");
		Employee joe = new Employee();
		joe.setName("Joe");
		joe.setSalary(2344);								
		joe.setAddress("Wifi City");

		// Create research department
		Department research = new Department();
		research.setManager(craig);
		research.setName("Research");
		research.getSubunits().add(erik);
		research.getSubunits().add(ralf);
		company.getDepts().add(research);

		// Create development department
		Department development = new Department();
		development.setManager(ray);
		development.setName("Development");
		company.getDepts().add(development);

		// Create sub-department dev1
		Department dev1 = new Department();
		development.getSubunits().add(dev1);
		dev1.setName("Dev1");
		dev1.setManager(klaus);

		// Create sub-department dev11
		Department dev11 = new Department();
		dev1.getSubunits().add(dev11);
		dev11.setName("Dev1.1");
		dev11.setManager(karl);
		dev11.getSubunits().add(joe);

		return company;
	}

}
