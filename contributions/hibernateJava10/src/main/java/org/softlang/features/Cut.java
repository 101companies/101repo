package org.softlang.features;

import org.softlang.company.*;

/**
 * Cut all salaries by half
 *
 */
public class Cut {

	public static void cut(Company company) {
		// cut all salaries in all top departments
		company.getDepts().forEach(Cut::cut);
	}

	public static void cut(Department dept) {
		// cut all employees' salaries
		dept.getEmployees().forEach(Cut::cut);

		// cut all salaries in all sub departments
		dept.getSubdepts().forEach(Cut::cut);
	}

	public static void cut(Employee employee) {
		// cut employee's salary by half
		employee.setSalary(employee.getSalary() / 2);
	}
}