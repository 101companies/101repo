package company.dao.hibernate;

import company.dao.hibernate.generic.GenericHibernateDAO;
import company.dao.interfaces.DepartmentDAO;
import company.hibernate.mapping.Department;

/**
 *
 * @author Tobias
 */
public class DepartmentDAOHibernate
        extends GenericHibernateDAO<Department, Long>
        implements DepartmentDAO {
}
