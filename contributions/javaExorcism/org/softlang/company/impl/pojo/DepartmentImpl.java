package org.softlang.company.impl.pojo;

import org.softlang.company.*;
import org.softlang.visitor.*;

public class DepartmentImpl extends ContainerImpl implements Department {

	public Employee getManager() {
		for (Subunit u : subunits())
			if (u instanceof Employee) {
				Employee e = (Employee)u;
				if (e.getManager())
					return e;
			}
		return null;
	}	

	public void accept(VoidVisitor v) {
		v.visit(this);
	}

	public <R> R accept(ReturningVisitor<R> v) {
		return v.visit(this);
	}
}
