package org.softlang.service.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import org.softlang.service.company.Employee;

@XmlRootElement
public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 7768217250635189944L;

	@XmlAttribute
	private String name;
	@XmlAttribute
	private String address;
	@XmlAttribute
	private double salary;

	public EmployeeDTO() {		
	}
	
	public EmployeeDTO(Employee emp) {
		this.name = emp.getName();
		this.address = emp.getAddress();
		this.salary = emp.getSalary();
	}
	
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
