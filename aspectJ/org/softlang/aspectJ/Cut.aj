package org.softlang.aspectJ;

import org.softlang.company.*;

public aspect Cut {

	public void Company.cut() {
		for (Department dept : getDepts())
			dept.cut();
	}

	public void Department.cut() {
		for (Subunit s : getSubunits())
			s.cut();
		getManager().cut();
	}

	public abstract void Subunit.cut();

	public void Employee.cut() {
		setSalary(getSalary() / 2);
	}

}
