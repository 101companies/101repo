package org.softlang.company;

import java.util.HashSet;
import java.util.Set;

/**
 * A company has a name and consists of (possibly nested) departments.
 * 
 */
public class Company {

	private Long id;
	private String name;
	private Set<Department> depts;

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
	
	public Set<Department> getDepts() {
		if (depts==null) 
			depts = new HashSet<Department>();
		return depts;
	}

	@SuppressWarnings("unused")
	private void setDepts(Set<Department> depts) {
		this.depts = depts;
	}
}
