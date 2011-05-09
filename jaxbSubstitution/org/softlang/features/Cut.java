// A variation that involves subtyping

package org.softlang.features;

import javax.xml.bind.JAXBElement;

import org.softlang.company.*;

public class Cut {
	
	public static void cut(Company c) {
		for (Department d : c.getDepartment())
			cut(d);
	}
	
	public static void cut(Department d) {
		cut(d.getManager());
		for (JAXBElement<? extends Subunit> s : d.getSubunit())
			cut(s.getValue());
	}
	
	public static void cut(Employee e) {
		e.setSalary(e.getSalary() / 2);
	}
		
	public static void cut(Subunit s) {
		if (s instanceof Department)
			cut(((Department)s));
		else if (s instanceof Employee)
			cut(((Employee)s));
		else throw new IllegalArgumentException();		
	}
}
