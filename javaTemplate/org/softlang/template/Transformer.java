package org.softlang.template;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

public class Transformer {

	public void visit(Company c) {
	}

	public void visit(Department d) {
	}

	public void visit(Employee e) {
	}
			
	public final void transform(Company c) {
		visit(c);
		for (Department d : c.getDepts())
			transform(d);
	}
	
	private final void transform(Department d) {
		visit(d);
		transform(d.getManager());
		for (Department s : d.getSubdepts())
			transform(s);
		for (Employee e : d.getEmployees())
			transform(e);
	}
	
	private final void transform(Employee e) {
		visit(e);
	}	
}
