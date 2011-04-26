package org.softlang.features;

import org.softlang.company.*;

public class Cut implements VoidVisitor {
	
	public void visit(Company o) {
		for (Department d : o.getDepts())
			d.accept(this);
	}	
	
	public void visit(Department o) {
		o.getManager().accept(this);
		for (Department s : o.getSubdepts())
			s.accept(this);
		for (Employee e : o.getEmployees())
			e.accept(this);
	}

	public void visit(Employee o) {
		o.setSalary(o.getSalary() / 2.0d);		
	}	
}
