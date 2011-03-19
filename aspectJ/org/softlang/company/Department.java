package org.softlang.company;

import java.util.LinkedList;
import java.util.List;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Department {

	private String name;
	private Employee manager;
	private List<Subunit> subunits;

	public Department() {
		name = "";
		subunits = new LinkedList<Subunit>();
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

	public List<Subunit> getSubunits() {
		return subunits;
	}
}
