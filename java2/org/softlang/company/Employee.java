package org.softlang.company;

import java.io.Serializable;

/**
 * An employee has a salary and some person information
 * 
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = -210889592677165250L;

	private String name;
	private double salary;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
		
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
