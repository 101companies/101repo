package org.softlang.server.company;

import java.util.LinkedList;
import java.util.List;

public class Company {

	private String name;
	private List<Dept> depts;

	public Company() {
		depts = new LinkedList<Dept>();
	}

	public List<Dept> getDepts() {
		return depts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double total() {
		double total = 0;
		for (Dept d : getDepts())
			total += d.total();
		return total;
	}

	public void cut() {
		for (Dept d : getDepts())
			d.cut();
	}
}
