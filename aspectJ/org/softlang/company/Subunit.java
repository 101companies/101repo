package org.softlang.company;

/**
 * A subunit is either an employee unit or a department unit
 * 
 */
public class Subunit {

	private Employee eUnit;
	private Dept dUnit;

	public Employee getEu() {
		return eUnit;
	}

	public void setEu(Employee eu) {
		dUnit = null;
		this.eUnit = eu;
	}

	public Dept getDu() {
		return dUnit;
	}

	public void setDu(Dept du) {
		eUnit = null;
		this.dUnit = du;
	}
}
