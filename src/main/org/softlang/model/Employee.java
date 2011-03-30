package org.softlang.model;

import javax.persistence.Entity;

@Entity
public class Employee extends Subunit {

	private String address;
	private Double salary;
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public void cut() {
		setSalary(getSalary() / 2);
	}
	
	@Override
	public double total() {
		return getSalary();
	}
	
}
