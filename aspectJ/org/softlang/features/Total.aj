package org.softlang.features;

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
		total += getManager().getSalary();
		for (Department s : getSubdepts())
			total += s.total();
		for (Employee e : getEmployees())
			total += e.getSalary();
		return total;		
	}

	public double Employee.total() {
		return getSalary();
	}

}
