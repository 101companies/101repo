package org.softlang.features;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Department implements Serializable {

	private static final long serialVersionUID = -2008895922177165250L;
	private String name;
	private Employee manager;
	private List<Department> subdepts;
	private List<Employee> employees;

	public Department() {
		subdepts = new LinkedList<Department>();
		employees = new LinkedList<Employee>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Department> getSubdepts() {
		return subdepts;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
}
