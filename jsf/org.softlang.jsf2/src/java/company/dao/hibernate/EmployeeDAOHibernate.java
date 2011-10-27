package company.dao.hibernate;

import company.dao.hibernate.generic.GenericHibernateDAO;
import company.dao.interfaces.EmployeeDAO;
import company.hibernate.mapping.Employee;

/**
 *
 * @author Tobias
 */
public class EmployeeDAOHibernate
        extends GenericHibernateDAO<Employee, Long>
        implements EmployeeDAO {
    
}
