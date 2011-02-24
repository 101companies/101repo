package org.softlang.om;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * A company is a list of departments
 * 
 */
public class Company {

	private Set<Dept> depts;

	public Company() {
		depts = new HashSet<Dept>();
	}

	public Set<Dept> getDepts() {
		return depts;
	}

	public void setDepts(Set<Dept> depts) {
		this.depts = depts;
	}

	// As the root of the any object tree, the Company instance hosts the session.
	
	private Session session;

	public static Company loadObject() {
		Company c =
			new Company();
		c.session = 
			new Configuration().
				configure().
				buildSessionFactory().
				getCurrentSession();		
		c.session.beginTransaction();
		// get all top departments
		List<?> depts = c.session.createQuery(
				"from Dept where UPPER_DEPT_ID is null").list();
		// add them to the company's top department list
		for (Object o : depts)
			c.getDepts().add((Dept) o);
		return c;
	}

	public void saveObject() {
		// save company by saving all top departments
		for (Dept dept : getDepts()) {
			session.save(dept);
		}
		session.getTransaction().commit();

	}
}
