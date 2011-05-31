package org.softlang.features;

import org.softlang.company.Employee;
import org.softlang.template.Transformer;

public class Cut extends Transformer {
	public void visit(Employee e) {
		e.setSalary(e.getSalary() / 2.0);
	}
}
