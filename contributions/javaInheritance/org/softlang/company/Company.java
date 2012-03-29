package org.softlang.company;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Company implements Serializable {

	private static final long serialVersionUID = -200889592677165250L;

	private String name;
	private List<Department> depts = new LinkedList<Department>();

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
