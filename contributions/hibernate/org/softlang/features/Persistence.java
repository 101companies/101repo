package org.softlang.features;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.softlang.company.*;

public class Persistence {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = 
            	new Configuration().
            	configure().
            	buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * This method makes the SessionFactory accessible from the outside.
     * Call Persistence.getSessionFactory().getCurrentSession() from anywhere
     * in the program to get access to the current session. On this session,
     * you can call beginTransaction() and then save(Object o) to prepare an
     * object for storage and later session.getTransaction.commit() to finally
     * write o into the database.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }	
	
	private Session session = Persistence.getSessionFactory().getCurrentSession();	
	
	/**
	 * Load company by name if possible.
	 * Create a fresh company object otherwise.
	 */
	public Company loadCompany(String name) {
		this.session = getSessionFactory().getCurrentSession();
		this.session.beginTransaction();
		List<?> result = this.session.createQuery(
				"from Company where name = '" + name + "'").list();
		for (Object o : result)
			return (Company)o;
		return null;
	}

	public void saveCompany(Company company) {
		session.save(company);
		session.getTransaction().commit();
	}

}
