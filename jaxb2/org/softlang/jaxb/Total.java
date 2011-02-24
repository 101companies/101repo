// A variation that involves subtyping

package org.softlang.jaxb;

import org.softlang.company.*;

public class Total {
	
	public static double total(Company c) {
		double total = 0;
		if (c.getDept() != null)
			for (Dept d : c.getDept())
				total += total(d);
		return total;
	}
	
	public static double total(Dept d) {
		double total = 0;
		if (d != null) {
			total += total(d.getManager());
			if (d.getSubunit() != null)
				for (Subunit s : d.getSubunit())
					total += total(s);
		}
		return total;		
	}
	
	public static double total(Employee e) {
		double total = 0;
		if (e != null)
			total += e.getSalary();
		return total;
	}

	// This is where subtyping kicks in.
	public static double total(Subunit s) {
		if (s instanceof Pu)
			return total(((Pu)s).getEmployee());
		if (s instanceof Du)
			return total(((Du)s).getDept());
		throw new IllegalArgumentException();
	}
}
