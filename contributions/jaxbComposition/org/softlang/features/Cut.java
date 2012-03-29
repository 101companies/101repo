// A variation that involves subtyping

package org.softlang.features;

import org.softlang.company.*;

public class Cut {
	
	public static void cut(Company c) {
		for (Department d : c.getDepartment())
			cut(d);
	}
	
	public static void cut(Department d) {
		cut(d.getManager());
		for (Department s : d.getDepartment())
			cut(s);
		for (Employee e : d.getEmployee())
			cut(e);
	}
	
	public static void cut(Employee e) {
		e.setSalary(e.getSalary() / 2);
	}
		
}
