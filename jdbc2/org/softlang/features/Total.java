package org.softlang.features;

import org.softlang.company.*;

/**
 * Total all salaries
 * 
 */
public class Total {

	public static double total(Company company) {
		double total = 0;
		for (Department dept : company.getDepts())
			total += total(dept);
		return total;
	}

	public static double total(Department dept) {
		double total = 0;
		total += dept.getManager().getSalary();
		for (Employee employee : dept.getEmployees())
			total += total(employee);
		for (Department subDept : dept.getSubDepts())
			total += total(subDept);
		return total;
	}

	public static double total(Employee employee) {
		return employee.getSalary();
	}

}
