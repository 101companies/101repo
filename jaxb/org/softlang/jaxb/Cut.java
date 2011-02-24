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
	
	public static void cut(Subunit s) {
		cut(s.getDu());
		cut(s.getPu());
	}
}
