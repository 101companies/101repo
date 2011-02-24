package org.softlang.hibernate;

import org.softlang.om.*;

/**
 * Cut all salaries by half
 * 
 */
public class Cut {

	public static void cut(Company company) {
		// cut all salaries in all top departments
		for (Dept dept : company.getDepts())
			cut(dept);
	}

	public static void cut(Dept dept) {
		// cut all employees' salaries
		for (Employee employee : dept.getEmployees())
			cut(employee);
		// cut all salaries in all sub departments
		for (Dept subDepartment : dept.getSubDepartments())
			cut(subDepartment);
	}

	public static void cut(Employee employee) {
		// cut employee's salary by half
		employee.setSalary(employee.getSalary() / 2);
	}

}
