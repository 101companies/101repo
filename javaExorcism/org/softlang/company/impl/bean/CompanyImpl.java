package org.softlang.company.impl.bean;

import org.softlang.company.*;
import org.softlang.visitor.*;

public class CompanyImpl extends ContainerImpl implements Company {

	public void accept(VoidVisitor v) {
		v.visit(this);
	}

	public <R> R accept(ReturningVisitor<R> v) {
		return v.visit(this);
	}	
}
