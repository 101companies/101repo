package org.softlang.company.impl.bean;

import org.softlang.company.*;
import org.softlang.visitor.*;

public class EmployeeImpl extends ComponentImpl implements Employee {

	private String name;
	private String address;
	private double salary;
	private boolean manager;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers("name");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		setChanged();
		notifyObservers("address");
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
		setChanged();
		notifyObservers("salary");
	}	
	
	public boolean getManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
		setChanged();
		notifyObservers("manager");
	}

	public void accept(VoidVisitor v) {
		v.visit(this);
	}

	public <R> R accept(ReturningVisitor<R> v) {
		return v.visit(this);
	}
}
