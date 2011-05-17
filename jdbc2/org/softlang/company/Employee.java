package org.softlang.company;

import org.softlang.util.ObjectFactory;

/**
 * An Employee has a salary and some person information
 * 
 */
public class Employee implements Persistable {

	private int id;
	private String name;
	private String address;
	private double salary;
	private boolean changed;
	private boolean loaded;
	private ObjectFactory objectFactory;

	public Employee() {
		id = 0;
		changed = true;
	}

	public Employee(int employeeid) {
		this.id = employeeid;
	}

	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public void load() {
		if (objectFactory != null && !loaded) {
			objectFactory.loadEmployee(this);
			loaded = true;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (this.id == 0)
			this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		changed = true;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		changed = true;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
		changed = true;
	}

	public void setChanged(boolean changed) {
		this.changed = true;
	}

	public boolean isChanged() {
		return changed;
	}

	public boolean equals(Object o) {
		Employee otherEmployee = (Employee) o;
		return this.getSalary() == otherEmployee.getSalary()
				&& this.getName().equals((otherEmployee).getName())
				&& this.getAddress().equals((otherEmployee).getAddress());
	}
}
