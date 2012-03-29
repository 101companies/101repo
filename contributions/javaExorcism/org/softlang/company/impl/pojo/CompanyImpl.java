package org.softlang.company.impl.pojo;

import org.softlang.company.*;
import org.softlang.visitor.*;

public class CompanyImpl extends ContainerImpl implements Company {

	/**
	 * Enforce the constraint a company can only aggregate departments
	 */
	public boolean add(Subunit u) {
		if (!(u instanceof Department))
			throw new IllegalArgumentException();
		return super.add(u);
	}
	
	public void accept(VoidVisitor v) {
		v.visit(this);
	}

	public <R> R accept(ReturningVisitor<R> v) {
		return v.visit(this);
	}	
}
