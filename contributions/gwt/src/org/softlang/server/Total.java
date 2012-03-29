package org.softlang.server;

import org.softlang.server.company.*;

/**
 * Total all salaries.
 * 
 */
public class Total {

	public static double totalCompany(Company company) {
		double ttl = 0;
		for (Dept dept : company.getDepts())
			ttl += totalDept(dept);
		return ttl;
	}

	public static double totalDept(Dept dept) {
		double ttl = 0;
		if (dept.getManager() != null)
			ttl += totalEmployee(dept.getManager());
		for (Subunit subunit : dept.getSubunits())
			ttl += totalSubunit(subunit);
		return ttl;

	}

	private static double totalSubunit(Subunit subunit) {
		if (subunit.getPu() != null)
			return totalEmployee(subunit.getPu());
		else
			return totalDept(subunit.getDu());
	}

	public static double totalEmployee(Employee employee) {
		return employee.getSalary();

	}

}
