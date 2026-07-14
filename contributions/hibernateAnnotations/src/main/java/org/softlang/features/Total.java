package org.softlang.features;

import org.softlang.company.*;

/**
 * Total all salaries
 *
 */
public class Total {

	public static double total(Company company) {
		// total all salaries in all top departments
		return company.getDepts()
				.stream()
				.mapToDouble(Total::total)
				.sum();
	}

	public static double total(Department dept) {
		// total all department's employees' salaries
		return dept.getEmployees()
				.stream()
				.mapToDouble(Total::total)
				.sum()

				// total all salaries in all sub departments
				+ dept.getSubdepts()
				.stream()
				.mapToDouble(Total::total)
				.sum();
	}

	public static double total(Employee employee) {
		return employee.getSalary();
	}
}