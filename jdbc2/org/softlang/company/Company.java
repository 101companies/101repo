package org.softlang.company;

import org.softlang.util.SimpleFlaggedList;

/**
 * A company is a list of departments
 * 
 */
public class Company {

	private SimpleFlaggedList<Dept> depts;
	private boolean changed;

	public Company() {
		depts = new SimpleFlaggedList<Dept>();
		changed = true;
	}

	public SimpleFlaggedList<Dept> getDepts() {
		return depts;
	}

	public void setUnchanged() {
		changed = false;
	}

	public boolean isChanged() {
		boolean deptsChanged = depts.wasChanged();
		for (Dept dept : depts)
			deptsChanged |= dept.isChanged();
		return deptsChanged || this.changed;
	}

	public boolean equals(Object o) {
		boolean isEqual = true;
		Company otherCompany = (Company) o;
		isEqual &= this.getDepts().size() == otherCompany.getDepts().size();
		for (int i = 0; i < this.getDepts().size() && isEqual; i++)
			isEqual &= this.getDepts().get(i).equals(
					otherCompany.getDepts().get(i));
		return isEqual;
	}

}
