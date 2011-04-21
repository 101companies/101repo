package org.softlang.aspectJ;

import org.softlang.company.*;

public aspect Cut {

	public void Company.cut() {
		for (Department dept : getDepts())
			dept.cut();
	}

	public void Department.cut() {
		getManager().cut();
		for (Department s : getSubdepts())
			s.cut();
		for (Employee e : getEmployees())
			e.cut();
	}

	public void Employee.cut() {
		setSalary(getSalary() / 2);
	}

}
