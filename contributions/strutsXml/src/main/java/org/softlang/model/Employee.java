package org.softlang.model;

import java.io.Serializable;

/**
 * An Employee has a salary and some person information
 * 
 */
public class Employee extends Subunit implements Serializable {

	private static final long serialVersionUID = -210889592677165250L;

	private Person person;
	private double salary;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public double total() {
		return getSalary();
	}	
	
	@Override
	public void cut() {
		setSalary(getSalary() / 2);
	}	
	
}
