package org.softlang.command;

import org.softlang.company.Employee;

/**
 * Encapsulate a salary cut for a given employee
 */
public class CutEmployee extends Command {

	private Employee e;
	private Double salary;
	
	/**
	 * Receive an employee whose salary is to be cut in half.
	 */
	public CutEmployee(Employee e) {
		this.e = e;
	}
	
	/**
	 * Save current salary.
	 * Cut salary in half.
	 */
	public void execute() {
		super.execute();
		salary = e.getSalary();
		e.setSalary(salary / 2.0);
	}
	
	/**
	 * Restore salary to saved value.
	 */
	public void undo() {
		super.undo();
		e.setSalary(salary);
	}
}
