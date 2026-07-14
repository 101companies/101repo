package org.softlang.company;

import java.util.*;

/**
 * A department has a name, a manager, employees, and subdepartments.
 * 
 */
public class Department {

	private Long id;
	private String name;
	private Set<Employee> employees;
	private Set<Department> subdepts;

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

	public Set<Employee> getEmployees() {
		if (employees==null) 
			employees = new HashSet<Employee>();
		return employees;
	}

	@SuppressWarnings("unused")
	private void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Department> getSubdepts() {
		if (subdepts==null) 
			subdepts = new HashSet<Department>();		
		return subdepts;
	}

	@SuppressWarnings("unused")
	private void setSubdepts(Set<Department> subdepts) {
		this.subdepts = subdepts;
	}
}
