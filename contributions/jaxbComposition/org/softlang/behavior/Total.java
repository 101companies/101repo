// A variation that involves subtyping

package org.softlang.behavior;

import org.softlang.model.*;

public class Total {
	
	public static double total(Company c) {
		double total = 0;
		for (Department d : c.getDepartment())
			total += total(d);
		return total;
	}
	
	public static double total(Department d) {
		double total = total(d.getManager());
		for (Department s : d.getDepartment())
			total += total(s);
		for (Employee e : d.getEmployee())
			total += total(e);
		return total;		
	}
	
	public static double total(Employee e) {
		return e.getSalary();
	}

}
