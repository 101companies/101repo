package org.softlang.server;

import org.softlang.server.company.*;

/**
 * Cut all salaries by half.
 * 
 */
public class Cut {

	public static void cutCompany(Company company) {
		for (Dept dept : company.getDepts())
			cutDept(dept);
	}

	public static void cutDept(Dept dept) {
		if (dept.getManager() != null)
			cutEmployee(dept.getManager());
		for (Subunit subunit : dept.getSubunits())
			cutSubunit(subunit);
	}

	private static void cutSubunit(Subunit subunit) {
		if (subunit.getPu() != null)
			cutEmployee(subunit.getPu());
		else
			cutDept(subunit.getDu());
	}

	public static void cutEmployee(Employee employee) {
		employee.setSalary(employee.getSalary() / 2);
	}

}
