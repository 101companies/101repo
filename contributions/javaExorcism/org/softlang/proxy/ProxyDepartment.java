package org.softlang.proxy;

import org.softlang.company.*;
import org.softlang.visitor.*;

/**
 * A proxy for departments to enforce access control policy for salaries.
 */
/* package */ class ProxyDepartment implements Department {

	private AccessControl context;
	private Department subject;
	
	/* package */ ProxyDepartment(AccessControl context, Department subject) {
		this.context = context;
		this.subject = subject;
	}

	public String getName() {
		return subject.getName();
	}

	public void setName(String name) {
		subject.setName(name);
	}
	
	public Iterable<? extends Subunit> subunits() {
		return subject.subunits();
	}

	public boolean add(Subunit u) {
		u = context.deploy(u);
		return subject.add(u);
	}

	public boolean remove(Subunit u) {
		return subject.remove(u);
	}

	public Employee getManager() {
		return subject.getManager();
	}		
	
	// Delegation is NOT appropriate here.
	public void accept(VoidVisitor v) {
		v.visit(this);
	}

	// Delegation is NOT appropriate here.
	public <R> R accept(ReturningVisitor<R> v) {
		return v.visit(this);
	}	
}
