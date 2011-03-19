package org.softlang.company;

/**
 * A subunit is either an employee unit or a department unit
 * 
 */
public class Subunit {

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
}
