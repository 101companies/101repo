package org.softlang.aspectJ;

import org.softlang.company.*;

/**
 * 
 * Tracing the cutting process
 * 
 */
public aspect Logging {

	// Helper methods to compose logging messages
	private String cutLogBefore(String type, String name) {
		return "> START Cutting " + type + " \"" + name + "\".";
	}

	private String cutLogAfter(String type, String name, double newSalary) {
		return "> DONE Cutting " + type + " \"" + name + "\". New Salary: "
				+ newSalary;
	}

	// pointcuts for cutting companies, departments and employees

	pointcut cutCompany(Company c):
		target(c) && call(void Company.cut());

	pointcut cutDept(Dept d):
		 target(d) && call(void Dept.cut());

	pointcut cutEmployee(Employee e):
		target(e) && call(void Employee.cut());

	// Logging a company salary cut
	before(Company c): cutCompany(c) {
		System.out.println(cutLogBefore("Company", c.getName()));
	}

	after(Company c): cutCompany(c) {
		System.out.println(cutLogAfter("Company", c.getName(), c.total()));
	}

	// Logging a department salary cut
	before(Dept d): cutDept(d) {
		System.out.println(cutLogBefore("Department", d.getName()));
	}

	after(Dept d): cutDept(d) {
		System.out.println(cutLogAfter("Dept", d.getName(), d.total()));
	}

	// Logging a employee salary cut
	before(Employee e): cutEmployee(e) {
		System.out.println(cutLogBefore("Employee", e.getPerson().getName()));
	}

	after(Employee e): cutEmployee(e) {
		System.out.println(cutLogAfter("Employee", e.getPerson().getName(), e.total()));
	}

}
