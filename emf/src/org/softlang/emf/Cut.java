package org.softlang.emf;

import company.*;

/**
 * Cut all salaries by half.
 * 
 */
public class Cut {

	public static void cutCompany(Company company) {
		for (Dept dept : company.getDepts())
			cut(dept);
	}

	private static void cut(Dept dept) {
		cut(dept.getManager());
		for (Subunit subunit : dept.getSubunits())
			cut(subunit);
	}

	private static void cut(Subunit subunit) {
		if (subunit.getPu() != null)
			cut(subunit.getPu());
		else
			cut(subunit.getDu());
	}

	private static void cut(Employee employee) {
		employee.setSalary(employee.getSalary() / 2);
	}

}
