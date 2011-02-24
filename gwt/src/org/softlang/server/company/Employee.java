package org.softlang.server.company;

import java.io.Serializable;

/**
 * An Employee has a salary and some person information
 * 
 */
public class Employee implements Serializable {

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

	public double total() {
		return getSalary();
	}

	public void cut() {
		setSalary(getSalary() / 2);
	}
}
