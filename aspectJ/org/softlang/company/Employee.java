package org.softlang.company;

/**
 * An employee has a salary and some person information
 * 
 */
public class Employee {

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
}
