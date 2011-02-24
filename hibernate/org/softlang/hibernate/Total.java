package org.softlang.hibernate;

import org.softlang.om.*;

/**
 * Total all salaries
 * 
 */
public class Total {

	public static double total(Company company) {
		double total = 0;
		// total all salaries in all top departments
		for (Dept dept : company.getDepts())
			total += total(dept);
		return total;
	}

	public static double total(Dept dept) {
		double total = 0;
		// total all department's employees' salaries
		for (Employee employee : dept.getEmployees())
			total += total(employee);
		// total all salaries in all sub departments
		for (Dept subDepartment : dept.getSubDepartments())
			total += total(subDepartment);
		return total;
	}

	public static double total(Employee employee) {
		return employee.getSalary();
	}

}
