package org.softlang.features;

import org.softlang.company.*;
import org.softlang.company.impl.bean.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Supervise all salary changes to obey the Precedence feature.
 */
public class Precedence implements Observer {
	
	public void update(Observable o, Object arg) {
		if (o instanceof EmployeeImpl && arg instanceof String) {
			EmployeeImpl e = (EmployeeImpl)o;
			if (((String)arg).equals("salary")) {
				DepartmentImpl d = (DepartmentImpl)e.getParent();
				if (!e.getManager()) {
					// An employee must have a smaller salary than the manager of the department.
					if (e.getSalary() >= d.getManager().getSalary())
						throw exception(e);
				} else {
					// A manager of the upper department, if any, must have a greater salary.
					if (d.getParent()!=null && d.getParent() instanceof DepartmentImpl)
						if (e.getSalary() >= ((DepartmentImpl)(d.getParent())).getManager().getSalary())
							throw exception(e);
					// All managed employees must have smaller salaries.
					// For sub-departments, the manager is tested only.
					for (Subunit u : d.subunits())
						if (u instanceof DepartmentImpl) {
							if (((DepartmentImpl)u).getManager().getSalary() >= e.getSalary())
								throw exception(e);								
						} else {
							if (u!=e && ((EmployeeImpl)u).getSalary() >= e.getSalary())
								throw exception(e);								
						}
				}
			}
		}
	}
	
	private RuntimeException exception(Employee e) {
		return new IllegalArgumentException("Precedence constraint violated for employee \"" + e.getName() + "\".");
	}
}
