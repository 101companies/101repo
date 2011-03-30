package org.softlang.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department extends Subunit {

	@ManyToOne
	private Employee manager;
	
	@OneToMany
	private List<Subunit> subunits;

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
