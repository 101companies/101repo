package org.softlang.om;

import java.util.*;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Dept {

	private Long id;

	private String name;
	private Employee manager;
	private Set<Employee> employees = new HashSet<Employee>();
	private Set<Dept> subDepartments = new HashSet<Dept>();

	public Dept() {
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
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

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Dept> getSubDepartments() {
		return subDepartments;
	}

	public void setSubDepartments(Set<Dept> subDepartments) {
		this.subDepartments = subDepartments;
	}

}
