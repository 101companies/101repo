package org.softlang.visitor;

import org.softlang.company.*;

public interface ReturningVisitor<R> {

	R visit(Company o);
	R visit(Department o);
	R visit(Employee o);

}
