package org.softlang.aspectJ;

import org.softlang.company.*;

public aspect Total {

	public double Company.total() {
		double total = 0;
		for (Department dept : getDepts())
			total += dept.total();
		return total;
	}

	public abstract double Subunit.total();

	public double Department.total() {
		double total = 0;
		total += getManager().total();
		for (Subunit s : getSubunits())
			total += s.total();
		return total;
	}

	public double Employee.total() {
		return getSalary();
	}

}
