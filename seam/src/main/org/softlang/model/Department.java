package org.softlang.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department extends Subunit {

	@ManyToOne(optional=true)
	private Employee manager;
	
	@ManyToOne
	private Company company;
	
	@OneToMany
	private List<Subunit> subunits;

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Subunit> getSubunits() {
		return subunits;
	}

	public void setSubunits(List<Subunit> subunits) {
		this.subunits = subunits;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}
	
	@Override
	public void cut() {
		manager.cut();
		
		for (Subunit subunit : subunits) {
			subunit.cut();
		}
	}

	@Override
	public double total() {
		double total = manager.total();

		for (Subunit subunit : subunits) {
			total += subunit.total();
		}
		
		return total;
	}


}
