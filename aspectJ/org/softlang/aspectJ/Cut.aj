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

	public void Subunit.cut() {
		if (getDu() != null)
			getDu().cut();
		if (getEu() != null)
			getEu().cut();
	}

	public void Employee.cut() {
		setSalary(getSalary() / 2);
	}

}
