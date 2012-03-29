package org.softlang.features;

import org.softlang.company.*;
import org.softlang.template.Reducer;
import org.softlang.util.AddDoubles;

/**
 * Salaries are totaled by reducing a company structure
 * such that salaries are extracted from any employee encountered.
 * There is also a walker-based implementation of the same operation.
 */
public class TotalReducer extends Reducer<Double> {

	public TotalReducer() {
		super(AddDoubles.getInstance());
	}
	
	public Double visit(Employee e) {
		return e.getSalary();
	}
}
