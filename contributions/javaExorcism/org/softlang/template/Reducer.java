package org.softlang.template;

import org.softlang.company.*;
import org.softlang.util.Monoid;
import org.softlang.visitor.ReturningVisitor;

/** 
 * Provide a template for reduction over company objects.
 * Reduction is parametric in a monoid.
 * The template is customized by overriding visitor methods.
 * By default the visit methods return the unit of the monoid.
 * The visit methods do not traverse into the objects.
 * Instead, object traversal is taken care of by the template method.
 */
public abstract class Reducer<R> implements ReturningVisitor<R> {

	private Monoid<R> monoid;
	
	protected Reducer(Monoid<R> m) { this.monoid = m; }
	
	public R visit(Company c) {
		return monoid.unit();
	}

	public R visit(Department d) {
		return monoid.unit();
	}

	public R visit(Employee e) {
		return monoid.unit();
	}
	
	public final R reduce(Component c) {
		//
		// Use an inner visitor to organize traversal.
		//
		final ReturningVisitor<R> that = this;
		return c.accept(
			new ReturningVisitor<R>() {
				public R visit(Company c) {
					R result = that.visit(c);
					for (Subunit u : c.subunits())
						result = monoid.append(result, u.accept(this));
					return result;
				}
				public R visit(Department d) {
					R result = that.visit(d);
					for (Subunit u : d.subunits())
						result = monoid.append(result, u.accept(this));
					return result;
				}
				public R visit(Employee e) {
					return that.visit(e);
				}		
			});
	}
}
