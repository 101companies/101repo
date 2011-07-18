package org.softlang.service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.softlang.service.company.*;

@WebService (name="Portal")
public class Portal {
	
	
	private static final Company theCompany;
	
	static {		
		// Create company
		Company sampleCompany = new Company();
		sampleCompany.setName("meganalysis");
		
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
		sampleCompany.getDepts().add(research);

		// Create development department
		Department development = new Department();
		development.setManager(ray);
		development.setName("Development");
		sampleCompany.getDepts().add(development);

		// Create sub-department dev1
		Department dev1 = new Department();
		dev1.setName("Dev1");
		dev1.setManager(klaus);
		development.getSubdepts().add(dev1);

		// Create sub-department dev11
		Department dev11 = new Department();
		dev11.setName("Dev1.1");
		dev11.setManager(karl);
		dev11.getEmployees().add(joe);
		dev1.getSubdepts().add(dev11);
		
		theCompany = sampleCompany;
	}
	
	@WebMethod
	public Double totalCompany() {
		return theCompany.total();
	}

	@WebMethod
	public Double totalDepartment(String name) {
		for(Department dep : theCompany.getDepts()) {
			if (dep.getName().equals(name)) {
				return dep.total();
			}
		}
		
		throw new NoSuchElementException("There is no department with name " + name + " in the company " + theCompany.getName());
	}	
	
	@WebMethod
	public void cutCompany() {
		theCompany.cut();
	}	
	
	@WebMethod
	public void cutDepartment(String name) {
		boolean found = false;
		for(Department dep : theCompany.getDepts()) {
			if (dep.getName().equals(name)) {
				dep.cut();
				found = true;
				break;
			}
		}
		
		if (!found) {
			throw new NoSuchElementException("There is no department with name " + name + " in the company " + theCompany.getName());
		}
	}	
	
	/*
CompanyDTO getCompany(String name);
DepartmentDTO getDepartment(String name);
EmployeeDTO getEmployee(String name);
void setCompanyName(String oldName, String newName);
void setDepartmentName(String oldName, String newName);
void setEmployeeName(String oldName, String newName);
void setEmployeeAddress(String oldAddress, String newAddress);
void setEmployeeSalary(Double oldSalary, Double newSalary);
	 * 
	 */
	
}
