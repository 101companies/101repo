package org.softlang.context;

import org.softlang.action.Action;
import org.softlang.company.Company;
import org.softlang.company.Department;

public abstract class CompanyContextManager {

	public static <X, Y> Y execute(Context context, Company company,
			Action<Department, Y> action) {
		for (Department department : company.getDepts()) {
			action.execute(context, department);
		}

		if (context instanceof ConcurrentContext) {
			((ConcurrentContext) context).waitForTermination();
		}

		return action.getResult();
	}

}
