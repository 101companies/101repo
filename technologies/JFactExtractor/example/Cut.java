package org.softlang.behavior;

import org.softlang.model.*;

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
