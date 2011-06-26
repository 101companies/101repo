package org.softlang.features;

import org.softlang.company.*;
import javaf.prelude.*;
import static javaf.syb.Transformation.*;

/**
 * A more selective cut operation such that manager salaries are cut only.
 * To this end, 
 */
public class CutManagers {

	public static void cutManagers(Company c) {
		traverse(null).apply(c);
	}	

	public static Action<Object> traverse(final Object parent) {
		return new Action<Object>() {
			public void apply(Object o) {
				orIdentity(updateSalary(parent)).apply(o);
				all(traverse(o)).apply(o);
			}
		};
	}
	
	public static Action<Employee> updateSalary(final Object parent) {
		return new Action<Employee>() {
			public void apply(Employee x) {
				if (parent instanceof Department)
					x.setSalary(x.getSalary() / 2);
			}
		};
	}
}
