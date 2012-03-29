package org.softlang.om;

import java.util.HashSet;
import java.util.Set;

/**
 * A company is a list of departments
 * 
 */
public class Company {

	private Set<Dept> depts;

	public Company() {
		depts = new HashSet<Dept>();
	}

	public Set<Dept> getDepts() {
		return depts;
	}

	public void setDepts(Set<Dept> depts) {
		this.depts = depts;
	}

}
