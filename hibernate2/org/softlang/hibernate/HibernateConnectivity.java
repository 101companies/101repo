package org.softlang.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.softlang.om.*;
import org.softlang.util.HibernateUtil;

public class HibernateConnectivity {

	private Session session;

	public HibernateConnectivity() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	public Company loadCompany() {
		if (!session.isOpen())
			session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Company company = new Company();
		// get all top departments
		List<?> depts = session.createQuery("from Dept").list();
		List<?> subunits = session.createQuery("from Subunit").list();
		for (Object o : subunits) {
			Subunit subunit = (Subunit) o;
			if (subunit.getDu() != null)
				depts.remove(subunit.getDu());
		}
		// add them to the company's top department list
		for (Object o : depts)
			company.getDepts().add((Dept) o);
		return company;
	}

	public void saveCompany(Company company) {
		// save company by saving all top departments
		for (Dept dept : company.getDepts()) {
			session.save(dept);
		}
		session.getTransaction().commit();

	}

}
