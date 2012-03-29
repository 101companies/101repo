package org.softlang.operations;

import org.softlang.company.*;

public class Total {
	
	public static Double total(Company c) {
		double total = 0;
		for (Department d : c.getDepts())
			total += total(d);
		return total;
	}
		
	public static double total(Department d) {
		double total = 0;
		total += total(d.getManager());
		for (Department s : d.getSubdepts())
			total += total(s);
		for (Employee e : d.getEmployees())
			total += total(e);
		return total;		
	}	
		
	public static double total(Employee e) {
		return e.getSalary();
	}	
	
}
