package org.softlang.jaxb;

import org.softlang.company.*;

public class Total {
	
	public static double total(Company c) {
		double total = 0;
		for (Department d : c.getDepartment())
			total += total(d);
		return total;
	}
	
	public static double total(Department d) {
		double total = total(d.getManager());
		for (Subunit s : d.getSubunit())
			total += total(s);
		return total;		
	}
	
	public static double total(Employee e) {
		return e.getSalary();
	}
	
	public static double total(Subunit s) {
		double total = 0;
		if (s.getEmployee() != null) total += total(s.getEmployee());
		if (s.getDepartment() != null) total += total(s.getDepartment());
		return total;
	}
}
