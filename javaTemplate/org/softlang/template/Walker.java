package org.softlang.template;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

/**
 * Provide the template method "walk" for traversing over companies.
 * The "walk" method is configured with "visit" methods for all possible types.
 */
public class Walker {

	public void visit(Company c) {
	}

	public void visit(Department d) {
	}

	public void visit(Employee e) {
	}
	
	/**
	 * Provide the template method "walk" for traversing over companies.
	 */
	public final void walk(Company c) {
		visit(c);
		for (Department d : c.getDepts())
			walk(d);
	}
	
	private void walk(Department d) {
		visit(d);
		walk(d.getManager());
		for (Department s : d.getSubdepts())
			walk(s);
		for (Employee e : d.getEmployees())
			walk(e);
	}
	
	private void walk(Employee e) {
		visit(e);
	}	
}
