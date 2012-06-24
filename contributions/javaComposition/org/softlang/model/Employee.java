package org.softlang.model;

import java.io.Serializable;

/**
 * An employee has a name, an address, and a salary. 
 */
public class Employee implements Serializable {

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
	
	public void cut() {
		setSalary(getSalary() / 2);
	}	
}
