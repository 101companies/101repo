package org.softlang.aspectJ;

import org.softlang.company.*;

public aspect Total {

	public double Company.total() {
		double total = 0;
		for (Department dept : getDepts())
			total += dept.total();
		return total;
	}

	public double Department.total() {
		double total = 0;
		total += getManager().total();
		for (Subunit s : getSubunits())
			total += s.total();
		return total;
	}

	public double Subunit.total() {
		double total = 0;
		total += getDu() == null ? 0 : getDu().total();
		total += getEu() == null ? 0 : getEu().total();
		return total;
	}

	public double Employee.total() {
		return getSalary();
	}

}
