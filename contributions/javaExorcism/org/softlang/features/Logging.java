package org.softlang.features;

import java.util.Observable;
import java.util.Observer;

import org.softlang.company.impl.bean.EmployeeImpl;

/**
 * Log all changes to salaries of employees.
 * Log them on stdout and count them.
 */
public class Logging implements Observer {

	private int size;
	
	public void update(Observable o, Object arg) {
		if (o instanceof EmployeeImpl && arg instanceof String) {
			EmployeeImpl e = (EmployeeImpl)o;
			if (((String)arg).equals("salary")) {
				size++;
				System.out.println("Salary of " + e.getName() + " adjusted to " + e.getSalary());
			}
		}
	}

	/**
	 * Get the number of entries in the log.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Reset the log.
	 */
	public void reset() {
		size = 0;
	}
}
