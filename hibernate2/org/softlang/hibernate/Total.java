package org.softlang.hibernate;

import org.softlang.om.*;

public class Total {

	public static double total(Company company) {
		double total = 0;
		for (Dept dept : company.getDepts())
			total += total(dept);
		return total;
	}

	private static double total(Dept dept) {
		double total = total(dept.getManager());
		for (Subunit subunit : dept.getSubunits())
			total += total(subunit);
		return total;

	}

	private static double total(Subunit subunit) {
		if (subunit.getPu() != null)
			return total(subunit.getPu());
		else
			return total(subunit.getDu());
	}

	private static double total(Employee employee) {
		return employee.getSalary();
	}
}
