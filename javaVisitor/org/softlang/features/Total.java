package org.softlang.features;

import org.softlang.company.*;

public class Total implements ReturningVisitor<Double> {

	public Double visit(Company o) {
		double total = 0;
		for (Department d : o.getDepts())
			total += d.accept(this);
		return total;
	}

	public Double visit(Department o) {
		double total = 0;
		total += o.getManager().accept(this);
		for (Department s : o.getSubdepts())
			total += s.accept(this);
		for (Employee e : o.getEmployees())
			total += e.accept(this);
		return total;				
	}

	public Double visit(Employee o) {
		return o.getSalary();
	}	
}
