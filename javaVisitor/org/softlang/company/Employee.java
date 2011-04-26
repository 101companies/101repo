package org.softlang.company;

import java.io.Serializable;

/**
 * An employee has a name, an address, and a salary. 
 */
public class Employee extends Subunit implements Serializable {

	private static final long serialVersionUID = -210889592677165250L;

	private String name;
	private String address;
	private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double total() {
		return getSalary();
	}	
	
	public void cut() {
		setSalary(getSalary() / 2);
	}	
	
	/**
	 * Accept a void visitor
	 */
	public void accept(VoidVisitor v) { v.visit(this); }
	
	/**
	 * Accept a returning visitor
	 */
	public <R> R accept(ReturningVisitor<R> v) { return v.visit(this); }
}
