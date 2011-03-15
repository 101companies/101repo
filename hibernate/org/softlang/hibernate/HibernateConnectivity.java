package org.softlang.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.softlang.om.*;
import org.softlang.util.HibernateUtil;

public class HibernateConnectivity {

	private Session session;

	public HibernateConnectivity() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	public Company loadCompany() {
		Company c = new Company();
		this.session = new Configuration().configure().buildSessionFactory()
				.getCurrentSession();
		this.session.beginTransaction();
		// get all top departments
		List<?> depts = this.session.createQuery(
				"from Dept where UPPER_DEPT_ID is null").list();
		// add them to the company's top department list
		for (Object o : depts)
			c.getDepts().add((Dept) o);
		return c;
	}

	public void saveCompany(Company company) {
		// save company by saving all top departments
		for (Dept dept : company.getDepts()) {
			session.save(dept);
		}
		session.getTransaction().commit();

	}

}
