package org.softlang.company;

import java.io.Serializable;

/**
 * A subunit is either an employee unit or a department unit
 * 
 */
public class Subunit implements Serializable {

	private static final long serialVersionUID = -2008895922137165250L;

	private Employee eUnit;
	private Department dUnit;

	public Employee getEu() {
		return eUnit;
	}

	public void setEu(Employee eu) {
		dUnit = null;
		this.eUnit = eu;
	}

	public Department getDu() {
		return dUnit;
	}

	public void setDu(Department du) {
		eUnit = null;
		this.dUnit = du;
	}

	public double total() {
		double total = 0;
		total += getDu() == null ? 0 : getDu().total();
		total += getEu() == null ? 0 : getEu().total();
		return total;	
	}	
	
	public void cut() {
		if (getDu() != null) getDu().cut();
		if (getEu() != null) getEu().cut();
	}	
}
