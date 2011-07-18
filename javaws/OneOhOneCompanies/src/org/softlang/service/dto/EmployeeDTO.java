package org.softlang.service.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 7768217250635189944L;

	private String name;
	private String address;
	private double salary;

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public double getSalary() {
		return salary;
	}
}
