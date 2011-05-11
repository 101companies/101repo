package org.softlang.features;

import org.softlang.company.*;

/**
 * Cut all salaries by half
 * 
 */
public class Cut {

	public static void cutCompany(Company company) {
		// cut all salaries in all top departments
		for (Department dept : company.getDepts())
			cutDept(dept);
	}

	public static void cutDept(Department dept) {
		cutEmployee(dept.getManager());
		// cut all employees' salaries
		for (Employee employee : dept.getEmployees())
			cutEmployee(employee);
		// cut all salaries in all sub departments
		for (Department subDepartment : dept.getSubDepartments())
			cutDept(subDepartment);
	}

	public static void cutEmployee(Employee employee) {
		// cut employee's salary by half
		employee.setSalary(employee.getSalary() / 2);
	}

}
