package company.dao.hibernate;

import company.dao.hibernate.generic.GenericHibernateDAO;
import company.dao.interfaces.CompanyDAO;
import company.classes.Company;

/**
 *
 * @author Tobias
 */
public class CompanyDAOHibernate
        extends GenericHibernateDAO<Company, Long>
        implements CompanyDAO {
    
}
