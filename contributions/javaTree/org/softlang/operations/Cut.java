package org.softlang.operations;

import org.softlang.company.*;

/**
 * This class provides the main feature "cut" of 101companies.
 * 
 */
public class Cut {

	/**
	 * cuts a given company.
	 * 
	 * @param company
	 */
	public static void cut(Company c) {
		for (Department d : c.getDepts())
			cut(d);
	}
	
	/**
	 * cuts a given department.
	 * 
	 * @param department
	 */
	public static void cut(Department d) {
		cut(d.getManager());
		for (Department s : d.getSubdepts())
			cut(s);
		for (Employee e : d.getEmployees())
			cut(e);
	}	
	
	/**
	 * cuts a given employee.
	 * 
	 * @param employee
	 */
	public static void cut(Employee e) {
		e.setSalary(e.getSalary() / 2);
	}	
	
}
