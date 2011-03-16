package org.softlang.company;

import java.util.LinkedList;
import java.util.List;

/**
 * A company has a name and a list of top departments.
 * 
 */
public class Company {

	private String name;
	private List<Dept> depts;
	
	public Company() {
		depts = new LinkedList<Dept>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dept> getDepts() {
		return depts;
	}
}
