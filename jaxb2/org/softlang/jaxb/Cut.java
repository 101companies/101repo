// A variation that involves subtyping

package org.softlang.jaxb;

import org.softlang.company.*;

public class Cut {
	
	public static void cut(Company c) {
		if (c.getDept() != null)
			for (Dept d : c.getDept())
				cut(d);
	}
	
	public static void cut(Dept d) {
		if (d != null) {
			cut(d.getManager());
			if (d.getSubunit() != null)
				for (Subunit s : d.getSubunit())
					cut(s);
		}
	}
	
	public static void cut(Employee e) {
		if (e != null)
			e.setSalary(e.getSalary() / 2);
	}
		
	// This is where subtyping kicks in.
	public static void cut(Subunit s) {
		if (s instanceof Pu)
			cut(((Pu)s).getEmployee());
		else if (s instanceof Du)
			cut(((Du)s).getDept());
		else
			throw new IllegalArgumentException();		
	}
}
