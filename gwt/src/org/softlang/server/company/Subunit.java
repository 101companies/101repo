package org.softlang.server.company;

import java.io.Serializable;

/**
 * A subunit is either a person unit or a department unit
 * 
 */
public class Subunit implements Serializable {

	private static final long serialVersionUID = -2008895922137165250L;

	private Employee pu;
	private Dept du;

	public Employee getPu() {
		return pu;
	}

	public void setPu(Employee pu) {
		du = null;
		this.pu = pu;
	}

	public Dept getDu() {
		return du;
	}

	public void setDu(Dept du) {
		pu = null;
		this.du = du;
	}

	public double total() {
		double total = 0;
		total += getDu() == null ? 0 : getDu().total();
		total += getPu() == null ? 0 : getPu().total();
		return total;
	}

	public void cut() {
		if (getDu() != null)
			getDu().cut();
		if (getPu() != null)
			getPu().cut();
	}
}
