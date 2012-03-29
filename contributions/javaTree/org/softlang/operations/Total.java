package org.softlang.operations;

import org.softlang.company.*;

/**
 * This class provides the main feature "total" of 101companies.
 * 
 */
public class Total {
	
	/**
	 * adds the salaries of all employees of a given company.
	 * 
	 * @param company
	 * @return total
	 */
	public static Double total(Company c) {
		double total = 0;
		for (Department d : c.getDepts())
			total += total(d);
		return total;
	}
	
	/**
	 * adds the salaries of all employees of a given department.
	 * 
	 * @param department
	 * @return total
	 */
	public static double total(Department d) {
		double total = 0;
		total += total(d.getManager());
		for (Department s : d.getSubdepts())
			total += total(s);
		for (Employee e : d.getEmployees())
			total += total(e);
		return total;		
	}	
	
	/**
	 * returns the salary of a given employee.
	 * 
	 * @param employee
	 * @return salary
	 */
	public static double total(Employee e) {
		return e.getSalary();
	}	
	
}
