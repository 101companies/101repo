package org.softlang.action;

import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.context.Context;

public class CutAction implements Action<Department, Void> {

	@Override
	public void execute(Context context, Department department) {
		// Lets context organize cutting the sub departments
		for (Department s : department.getSubdepts()) {
			context.execute(this, s);
		}

		// Cut manager and employees
		department.getManager().cut();
		for (Employee e : department.getEmployees()) {
			e.cut();
		}
	}

	@Override
	public Void getResult() {
		return null;
	}

}
