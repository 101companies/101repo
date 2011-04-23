package org.softlang.model;

import java.io.Serializable;

/**
 * A subunit is either a person unit or a department unit
 * 
 */
public abstract class Subunit implements Serializable {

	private static final long serialVersionUID = -2008895922137165250L;

	public abstract double total();
	public abstract void cut();
	public boolean isDepartment() { 
		return false;
	}
}
