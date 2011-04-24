package org.softlang.emf;

import company.*;

/**
 * Total all salaries.
 * 
 */
public class Total {

	public static double total(Company company) {
		double total = 0;
		for (Department dept : company.getDepts())
			total += total(dept);
		return total;
	}

	private static double total(Department dept) {
		double total = total(dept.getManager());
		for (Department subdept : dept.getSubdepts())
			total += total(subdept);
		for (Employee employee : dept.getEmployees())
			total += total(employee);
		return total;

	}

	private static double total(Employee employee) {
		return employee.getSalary();

	}

}
