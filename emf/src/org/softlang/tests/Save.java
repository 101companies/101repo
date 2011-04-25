package org.softlang.tests;

import java.io.IOException;

import company.impl.CompanyFactoryImpl;
import company.CompanyFactory;
import company.Company;
import company.Department;
import company.Employee;
import static org.softlang.features.Serialization.*;
import org.junit.Test;

public class Save {
	
	public static Company getSampleCompany() {
		
		CompanyFactory factory = new CompanyFactoryImpl();
		Company company = factory.createCompany();

		company.setName("meganalysis");

		Employee craig = factory.createEmployee();
		craig.setName("Craig");
		craig.setAddress("Redmond");
		craig.setSalary(123456);
		Employee erik = factory.createEmployee();
		erik.setName("Erik");
		erik.setAddress("Utrecht");
		erik.setSalary(12345);
		erik.setMentor(craig);
		Employee ralf = factory.createEmployee();
		ralf.setName("Ralf");
		ralf.setAddress("Koblenz");
		ralf.setSalary(1234);
		ralf.setMentor(erik);
		Employee ray = factory.createEmployee();
		ray.setName("Ray");
		ray.setAddress("Redmond");
		ray.setSalary(234567);
		Employee klaus = factory.createEmployee();
		klaus.setName("Klaus");
		klaus.setAddress("Boston");
		klaus.setSalary(23456);
		klaus.setMentor(ray);
		Employee karl = factory.createEmployee();
		karl.setName("Karl");
		karl.setAddress("Riga");
		karl.setSalary(2345);
		karl.setMentor(klaus);
		Employee joe = factory.createEmployee();
		joe.setName("Joe");
		joe.setAddress("Wifi City");
		joe.setSalary(2344);
		joe.setMentor(klaus);

		Department research = factory.createDepartment();
		
		research.setManager(craig);
		research.setName("Research");
		research.getEmployees().add(erik);
		research.getEmployees().add(ralf);

		Department development = factory.createDepartment();
		development.setManager(ray);
		development.setName("Development");
		Department dev1 = factory.createDepartment();
		dev1.setName("Dev1");
		dev1.setManager(klaus);
		development.getSubdepts().add(dev1);
		Department dev11 = factory.createDepartment();
		dev11.setName("Dev1.1");
		dev11.setManager(karl);
		dev1.getSubdepts().add(dev11);
		dev1.getEmployees().add(joe);

		company.getDepts().add(research);
		company.getDepts().add(development);

		return company;
	}
	
	@Test
	public void testSave() throws IOException {
		Company sampleCompany = getSampleCompany();
		saveCompany(sampleCompany,"sampleCompany");		
	}
	
}
