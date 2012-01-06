package org.softlang.server.company;

public class Employee {

	private int id;
	private String name;
	private String address;
	private double salary;
	private boolean manager;
	private Department parent;
	
	public Employee(int id, String name, String address, double salary, boolean manager) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.manager = manager;
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
	
	public boolean isManager() {
		return manager;
	}
	
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	public int getId() {
		return id;
	}

	public void cut() {
		this.salary = this.salary / 2;
	}
	
	public void setParent(Department parent) {
		if (this.parent != null) {
			this.parent.getEmployees().remove(this);
		}
		this.parent = parent;
		this.parent.getEmployees().add(this);
	}
	
	public Department getParent() {
		return this.parent;
	}
	
}
