package org.softlang.template;

import org.softlang.company.*;

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
		
	public abstract R zero();

	public abstract R append(R x, R y);	
	
	public final R reduce(Company c) {
		R result = visit(c);
		for (Department d : c.getDepts())
			result = append(result,reduce(d));
		return result;
	}
	
	private final R reduce(Department d) {
		R result = visit(d);
		result = append(result,reduce(d.getManager()));
		for (Department s : d.getSubdepts())
			result = append(result,reduce(s));
		for (Employee e : d.getEmployees())
			result = append(result,reduce(e));
		return result;
	}
	
	private final R reduce(Employee e) {
		return visit(e);
	}	
}
