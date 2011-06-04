package org.softlang.template;

import org.softlang.company.*;

/**
 * Provide the template method "reduce" for querying values from companies.
 * The "reduce" method is configured with "visit" methods for all possible types.
 * There are also abstract methods for the result domain: "zero" and "append".
 */
public abstract class Reducer<R> {

	public R visit(Company c) {
		return zero();
	}

	public R visit(Department d) {
		return zero();
	}

	public R visit(Employee e) {
		return zero();
	}
		
	/**
	 * @return the default (the algebraic unit) for the result type.
	 */
	public abstract R zero();

	/**
	 * Combine two query results.
	 */
	public abstract R append(R x, R y);	
	
	/**
	 * Provide the template method "reduce" for querying values from companies.
	 */
	public final R reduce(Company c) {
		R result = visit(c);
		for (Department d : c.getDepts())
			result = append(result,reduce(d));
		return result;
	}
	
	private R reduce(Department d) {
		R result = visit(d);
		result = append(result,reduce(d.getManager()));
		for (Department s : d.getSubdepts())
			result = append(result,reduce(s));
		for (Employee e : d.getEmployees())
			result = append(result,reduce(e));
		return result;
	}
	
	private R reduce(Employee e) {
		return visit(e);
	}	
}
