package org.softlang.om;

/**
 * A subunit is either a person unit or a department unit
 * 
 */
public class Subunit {

	private long id;
	private Employee pu;
	private Dept du;

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public Employee getPu() {
		return pu;
	}

	public void setPu(Employee pu) {
		this.pu = pu;
		this.du = null;
	}

	public Dept getDu() {
		return du;
	}

	public void setDu(Dept du) {
		this.pu = null;
		this.du = du;
	}

}
