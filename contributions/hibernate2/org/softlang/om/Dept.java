package org.softlang.om;

import java.util.*;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Dept {

	private Long id;

	private String name;
	private Employee manager;
	private Set<Subunit> subunits = new HashSet<Subunit>();

	public Dept() {
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
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

	public Set<Subunit> getSubunits() {
		return subunits;
	}

	public void setSubunits(Set<Subunit> subunits) {
		this.subunits = subunits;
	}

}
