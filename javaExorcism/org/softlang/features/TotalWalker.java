package org.softlang.features;

import org.softlang.company.*;
import org.softlang.template.Walker;

/**
 * Salaries are totaled by walking over the company structure
 * and summing up salaries via a designated field of the walker.
 * There is also a reducer-based implementation of the same operation.
 */
public class TotalWalker extends Walker {

	private double total = 0.0;
	
	public double getTotal() {
		return total;
	}
	
	public void visit(Employee e) {
		total += e.getSalary();
	}
}
