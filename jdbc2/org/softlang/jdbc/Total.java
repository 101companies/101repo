package org.softlang.jdbc;

import org.softlang.company.*;

/**
 * Total all salaries
 * 
 */
public class Total {

	public static double total(Company company) {
		double ttl = 0;
		// total all salaries in all top departments
		for (Dept dept : company.getDepts())
			ttl += total(dept);
		return ttl;
	}

	public static double total(Dept dept) {
		double ttl = 0;
		// total all department's employees' salaries
		for (Employee employee : dept.getEmployees())
			ttl += total(employee);
		// total all salaries in all sub departments
		for (Dept subDepartment : dept.getSubDepartments())
			ttl += total(subDepartment);
		return ttl;
	}

	public static double total(Employee employee) {
		return employee.getSalary();
	}

}
