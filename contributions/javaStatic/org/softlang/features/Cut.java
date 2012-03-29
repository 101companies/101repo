package org.softlang.features;

import org.softlang.company.*;

public class Cut {

	public static void cut(Company that) {
		for (Department d : that.getDepts())
			cut(d);
	}	
	
	public static void cut(Department that) {
		cut(that.getManager());
		for (Department s : that.getSubdepts())
			cut(s);
		for (Employee e : that.getEmployees())
			cut(e);
	}	

	public static void cut(Employee that) {
		that.setSalary(that.getSalary() / 2);
	}	
}
