package org.softlang.aspectJ;

import org.softlang.company.*;

/**
 * 
 * Tracing the cutting process
 * 
 */
public aspect Logging {

	// Helper methods to compose logging messages

	private String cutLogBefore(String type, String name, double salary) {
		return "> START Cutting " + type + " \"" + name + "\". Salary: " + salary;
	}

	private String cutLogAfter(String type, String name, double salary) {
		return "> DONE Cutting " + type + " \"" + name + "\". Salary: " + salary;
	}

	// pointcuts for cutting companies, departments and employees

	pointcut cutCompany(Company c):
		target(c) && call(void Company.cut());

	pointcut cutDept(Department d):
		 target(d) && call(void Department.cut());

	pointcut cutEmployee(Employee e):
		target(e) && call(void Employee.cut());
	
	// Logging a company salary cut
	void around(Company c): cutCompany(c) {
		System.out.println(cutLogBefore("Company", c.getName(), c.total()));
		proceed(c);
		System.out.println(cutLogAfter("Company", c.getName(), c.total()));
	}

	// Logging a department salary cut
	void around(Department d): cutDept(d) {
		System.out.println(cutLogBefore("Department", d.getName(), d.total()));
		proceed(d);
		System.out.println(cutLogAfter("Department", d.getName(), d.total()));
	}

	// Logging a employee salary cut
	void around(Employee e): cutEmployee(e) {
		System.out.println(cutLogBefore("Employee", e.getPerson().getName(), e.total()));
		proceed(e);
		System.out.println(cutLogAfter("Employee", e.getPerson().getName(), e.total()));
	}

}
