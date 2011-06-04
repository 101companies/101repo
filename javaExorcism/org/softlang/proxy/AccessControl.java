package org.softlang.proxy;

import org.softlang.company.*;
import java.util.List;
import java.util.LinkedList;

/**
 * Provide access control to salaries of employees.
 * A "Deploy" object essentially installs proxies for all employees in a companies.
 * By default, all such proxies continue to have full read/write access to salaries.
 * There are methods to enable/disable read/write access to salaries.
 */
public final class AccessControl {

	private boolean read = true;
	private boolean write = true;
	
	/** Test if salaries are readable **/
	public boolean isReadable() { return read; }

	/** Test if salaries are writable **/
	public boolean isWritable() { return write; }
		
	/** Enable read access. **/
	public void enableReadAcccess() { read = true; }

	/** Disable read access (and write access implicitly). **/
	public void disableReadAcccess() { read = false; write = false; }

	/** Enable write access (and read access implicitly). **/
	public void enableWriteAcccess() { read = true; write = true; }

	/** Disable write access. **/
	public void disableWriteAcccess() { write = false; }
	
	/** Wrap company in proxy for access control to salaries **/
	public Company deploy(Company c) {
		if (c instanceof ProxyCompany)
			return c;
		else {
			c = new ProxyCompany(this, c);
			deploy((Container)c);
			return c;
		}
	}
		
	/** Wrap department in proxy for access control to salaries **/
	public Department deploy(Department d) {
		if (d instanceof ProxyDepartment)
			return d;
		else {
			d = new ProxyDepartment(this, d);
			deploy((Container)d);
			return d;
		}
	}

	/** Wrap employee in proxy for access control to salaries **/
	public Employee deploy(Employee e) {
		if (e instanceof ProxyEmployee)
			return e;
		else {
			e = new ProxyEmployee(this, e);
			return e;
		}
	}
	
	/** Install proxy for a subunit and all its sub-sub-units, if any **/
	/* package */ Subunit deploy(Subunit u) {
		return (u instanceof Department) ?
			  deploy((Department)u)
			: deploy((Employee)u);
	}
		
	// Process subunits of containers
	private void deploy(Container c) {
		List<Subunit> before = new LinkedList<Subunit>();
		List<Subunit> after = new LinkedList<Subunit>();		
		for (Subunit u1 : c.subunits()) {
			Subunit u2 = deploy(u1);
			if (u1!=u2) {
				before.add(u1);
				after.add(u2);
			}
		}
		for (Subunit u : before)
			c.remove(u);
		for (Subunit u : after)
			c.add(u);
	}
}
