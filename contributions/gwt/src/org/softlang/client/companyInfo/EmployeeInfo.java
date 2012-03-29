package org.softlang.client.companyInfo;

import java.io.Serializable;

public class EmployeeInfo implements Serializable {

	private static final long serialVersionUID = 7768217250635189944L;
	private String name;
	private String address;
	private double salary;

	public EmployeeInfo() {
		name = "";
		address = "";
	}

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
}
