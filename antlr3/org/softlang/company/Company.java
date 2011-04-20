package org.softlang.company;

import java.util.LinkedList;
import java.util.List;

/**
 * A company has a name and consists of (possibly nested) departments.
 */
public class Company {

	private String name;
	private List<Department> depts = new LinkedList<Department>();

	public Company() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepts() {
		return depts;
	}
	
	public Double total() {
		double total = 0;
		for (Department d : getDepts())
			total += d.total();
		return total;
	}	
	
	public void cut() {
		for (Department d : getDepts())
			d.cut();
	}	
}
