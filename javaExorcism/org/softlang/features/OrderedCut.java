package org.softlang.features;

import org.softlang.company.*;
import org.softlang.template.Walker;

/**
 * A more complex cut is implemented for the sake of the Precedence feature.
 * That is, managers are cut after all other employees were cut.
 * A post-order walker / traversal is assumed here.
 * Without such effort, the precedence constraint could be violated very briefly.
 */
public class OrderedCut extends Walker {
	public void visit(Department d) {
		Employee e = d.getManager();
		e.setSalary(e.getSalary() / 2.0);
	}
	public void visit(Employee e) {
		if (!e.getManager())
			e.setSalary(e.getSalary() / 2.0);
	}
}
