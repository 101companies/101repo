package org.softlang.service;

import java.util.NoSuchElementException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.softlang.service.company.*;
import org.softlang.service.dto.*;

@WebService(name = "Portal")
public class Portal {

	private static Company theCompany;

	static {
		init();
	}
	
	private static void init() {
		// Create company
		theCompany = new Company();		
		theCompany.setName("meganalysis");

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
		theCompany.getDepts().add(research);

		// Create development department
		Department development = new Department();
		development.setManager(ray);
		development.setName("Development");
		theCompany.getDepts().add(development);

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
	}

	@WebMethod 
	public void reset() {
		Portal.init();
	}
	
	@WebMethod
	public Double totalCompany() {
		return theCompany.total();
	}

	@WebMethod
	public Double totalDepartment(String name) {
		return resolveDepartment(name).total();
	}

	@WebMethod
	public void cutCompany() {
		theCompany.cut();
	}

	@WebMethod
	public void cutDepartment(String name) {
		resolveDepartment(name).cut();
	}

	@WebMethod
	public CompanyDTO getCompany() {
		return new CompanyDTO(theCompany);
	}

	@WebMethod
	public DepartmentDTO getDepartment(String name) {
		return new DepartmentDTO(resolveDepartment(name));
	}

	@WebMethod
	public EmployeeDTO getEmployee(String name) {
		return new EmployeeDTO(resolveEmployee(name));
	}

	@WebMethod
	public void setCompanyName(String newName) {
		theCompany.setName(newName);
	}

	@WebMethod
	public void setDepartmentName(String oldName, String newName) {
		resolveDepartment(oldName).setName(newName);
	}

	@WebMethod
	public void setEmployeeName(String oldName, String newName) {
		resolveEmployee(oldName).setName(newName);
	}

	@WebMethod
	public void setEmployeeAddress(String name, String newAddress) {
		resolveEmployee(name).setAddress(newAddress);
	}

	@WebMethod
	public void setEmployeeSalary(String name, Double newSalary) {
		resolveEmployee(name).setSalary(newSalary);
	}


	private static Department resolveDepartment(String name) {
		for (Department dep : theCompany.getDepts()) {
			if (dep.getName().equals(name)) {
				return dep;
			}
		}

		throw new NoSuchElementException("There is no department with name "
				+ name + " in the company " + theCompany.getName());
	}

	private static Employee resolveEmployee(String name) {
		for (Department dep : theCompany.getDepts()) {
			for (Employee emp : dep.getEmployees()) {
				if (emp.getName().equals(name)) {
					return emp;
				}
			}
		}

		throw new NoSuchElementException("There is no person with name " + name
				+ " in the company " + theCompany.getName());
	}

}
