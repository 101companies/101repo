package org.softlang.emf;

import company.*;

/**
 * Cut all salaries by half.
 * 
 */
public class Cut {

	public static void cutCompany(Company company) {

		for (Department dept : company.getDepts())
			cut(dept);
	}

	private static void cut(Department dept) {
		cut(dept.getManager());
		for (Department subdept : dept.getSubdepts())
			cut(subdept);
		for (Employee employee : dept.getEmployees())
			cut(employee);
	}

	private static void cut(Employee employee) {
		employee.setSalary(employee.getSalary() / 2);
	}

}
