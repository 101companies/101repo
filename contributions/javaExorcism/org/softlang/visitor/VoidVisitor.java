package org.softlang.visitor;

import org.softlang.company.*;

public interface VoidVisitor {

	void visit(Company o);
	void visit(Department o);
	void visit(Employee o);
		
}
