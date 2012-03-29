package org.softlang.proxy;

import org.softlang.company.*;
import org.softlang.visitor.*;

/**
 * A proxy for companies to enforce access control policy for salaries.
 */
/* package */ class ProxyCompany implements Company {

	private AccessControl context;
	private Company subject;
	
	/* package */ ProxyCompany(AccessControl context, Company subject) {
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

	// Delegation is NOT appropriate here.
	public void accept(VoidVisitor v) {
		v.visit(this);
	}

	// Delegation is NOT appropriate here.
	public <R> R accept(ReturningVisitor<R> v) {
		return v.visit(this);
	}	
}
