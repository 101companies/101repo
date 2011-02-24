package org.softlang.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 * This class provides access to Hibernate Sessions from
 * everywhere in the program. 
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * This method makes the SessionFactory accessible from the outside.
     * Call HibernateUtil.getSessionFactory().getCurrentSession() from anywhere
     * in the program to get access to the current session. On this session,
     * you can call beginTransaction() and then save(Object o) to prepare an
     * object for storage and later session.getTransaction.commit() to finally
     * write o into the database.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}