package org.softlang.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Dept extends Subunit implements Serializable {

	private static final long serialVersionUID = -2008895922177165250L;
	private String name;
	private Employee manager;
	private List<Subunit> subunits;

	public void setSubunits(List<Subunit> subunits) {
		this.subunits = subunits;
	}

	public Dept() {
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

	@Override
	public double total() {
		double total = 0;
		total += getManager().total();
		for (Subunit s : getSubunits())
			total += s.total();
		return total;		
	}	
	
	@Override
	public void cut() {
		getManager().cut();
		for (Subunit s : getSubunits())
			s.cut();
	}

	@Override
	public boolean isDepartment() {
		return true;
	}	
}
