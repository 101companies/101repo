package org.softlang.basics;


/**
 * A subunit is either an employee unit or a department unit
 * 
 */
public abstract class Subunit  {
	
	public abstract double getTotal();	
	public abstract void cut();
	public abstract boolean isDepartment();
}
