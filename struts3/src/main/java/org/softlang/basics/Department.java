package org.softlang.basics;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Department extends Subunit implements Serializable {

	private static final long serialVersionUID = -3988985134498522566L;

	private Long id;
	private String name;
	private Employee manager;
	private List<Subunit> subunits;

	public Department() {
		subunits = new LinkedList<Subunit>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getTotal() {
		double total = 0;
		total += getManager().getTotal();
		for (Subunit s : getSubunits())
			total += s.getTotal();
		return total;		
	}	
	
	public void cut() {
		getManager().cut();
		for (Subunit s : getSubunits())
			s.cut();
	}

	public Department findDepartment(Long id) {
		if (this.getId().equals(id)) {
			return this;
		}
		else {
			for (Subunit s : subunits) {
				if (s instanceof Department) {
					Department subDepartment = (Department) s;
					Department result = subDepartment.findDepartment(id);
					
					if(result != null) {
						return result;
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean isDepartment() {
		return true;
	}	
}
