package org.softlang.features;

import org.softlang.company.*;

/**
 * Cut all salaries by half
 * 
 */
public class Cut {

	public static void cut(Company company) {
		// cut all salaries in all top departments
		for (Department dept : company.getDepts())
			cut(dept);
	}

	public static void cut(Department dept) {
		// cut all employees' salaries
		for (Employee employee : dept.getEmployees())
			cut(employee);
		// cut all salaries in all sub departments
		for (Department subDepartment : dept.getSubdepts())
			cut(subDepartment);
	}

	public static void cut(Employee employee) {
		// cut employee's salary by half
		employee.setSalary(employee.getSalary() / 2);
	}

}
