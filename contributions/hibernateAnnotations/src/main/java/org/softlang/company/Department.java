package org.softlang.company;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A department has a name, a manager, employees, and subdepartments.
 * 
 */
@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="dept_id")
	private Set<Employee> employees;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="dept_id")
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
