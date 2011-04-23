package org.softlang.features;

import org.softlang.company.*;

/**
 * Total all salaries
 * 
 */
public class Total {

	public static double total(Company company) {
		double total = 0;
		// total all salaries in all top departments
		for (Department dept : company.getDepts())
			total += total(dept);
		return total;
	}

	public static double total(Department dept) {
		double total = 0;
		// total all department's employees' salaries
		for (Employee employee : dept.getEmployees())
			total += total(employee);
		// total all salaries in all sub departments
		for (Department subDepartment : dept.getSubdepts())
			total += total(subDepartment);
		return total;
	}

	public static double total(Employee employee) {
		return employee.getSalary();
	}

}
