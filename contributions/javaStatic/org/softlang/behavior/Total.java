package org.softlang.behavior;

import org.softlang.model.*;

public class Total {

	public static Double total(Company that) {
		double total = 0;
		for (Department d : that.getDepts())
			total += total(d);
		return total;
	}	
	
	public static double total(Department that) {
		double total = 0;
		total += total(that.getManager());
		for (Department s : that.getSubdepts())
			total += total(s);
		for (Employee e : that.getEmployees())
			total += total(e);
		return total;		
	}	

	public static double total(Employee that) {
		return that.getSalary();
	}
}
