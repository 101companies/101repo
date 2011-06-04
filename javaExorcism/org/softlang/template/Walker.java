package org.softlang.template;

import org.softlang.company.*;
import org.softlang.visitor.VoidVisitor;

/** 
 * Provide a template for walking over company objects.
 * In fact, both pre- and post-order is supported.
 * The template is customized by overriding visitor methods.
 * By default the visit methods are no-ops.
 * The visit methods do not traverse into the objects.
 * Instead, object traversal is taken care of by the template method.
 */
public class Walker implements VoidVisitor {

	public void visit(Company c) {
	}

	public void visit(Department d) {
	}

	public void visit(Employee e) {
	}
			
	public final void preorder(Component c) {
		//
		// Use an inner visitor to organize traversal.
		//
		final VoidVisitor that = this;
		c.accept(
				new VoidVisitor() {
					public void visit(Company c) {
						that.visit(c);
						for (Subunit u : c.subunits())
							u.accept(this);
					}
					public void visit(Department d) {
						that.visit(d);
						for (Subunit u : d.subunits())
							u.accept(this);
					}
					public void visit(Employee e) {
						that.visit(e);
					}		
				});
	}	
	public final void postorder(Component c) {
		//
		// Use an inner visitor to organize traversal.
		//
		final VoidVisitor that = this;
		c.accept(
				new VoidVisitor() {
					public void visit(Company c) {
						for (Subunit u : c.subunits())
							u.accept(this);
						that.visit(c);
					}
					public void visit(Department d) {
						for (Subunit u : d.subunits())
							u.accept(this);
						that.visit(d);
					}
					public void visit(Employee e) {
						that.visit(e);
					}		
				});
	}		
}
