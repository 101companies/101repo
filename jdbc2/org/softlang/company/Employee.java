package org.softlang.company;

/**
 * An Employee has a salary and some person information
 * 
 */
public class Employee implements Loadable {

	private int employeeid;
	private String name;
	private String address;
	private double salary;
	private boolean changed;
	private boolean loaded;
	private ObjectFactory objectFactory;

	public Employee() {
		employeeid = 0;
		changed = true;
	}

	public Employee(int employeeid) {
		this.employeeid = employeeid;
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

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmploeeid(int employeeid) {
		if (this.employeeid == 0)
			this.employeeid = employeeid;
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

	public void setUnchanged() {
		changed = false;
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
