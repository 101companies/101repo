package org.softlang.company;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * A department has a name, a manager, employees, and subdepartments.
 */
public class Department implements Serializable {

	private static final long serialVersionUID = -2008895922177165250L;
	private String name;
	private Employee manager;
	private List<Department> subdepts = new LinkedList<Department>();
	private List<Employee> employees = new LinkedList<Employee>();

	/**
	 * Accept a void visitor
	 */
	public void accept(VoidVisitor v) { v.visit(this); }
	
	/**
	 * Accept a returning visitor
	 */
	public <R> R accept(ReturningVisitor<R> v) { return v.visit(this); }

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
