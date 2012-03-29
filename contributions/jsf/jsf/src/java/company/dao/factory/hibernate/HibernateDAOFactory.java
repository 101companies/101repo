package company.dao.factory.hibernate;

import company.dao.factory.DAOFactory;
import company.dao.hibernate.generic.GenericHibernateDAO;
import company.dao.hibernate.CompanyDAOHibernate;
import company.dao.hibernate.DepartmentDAOHibernate;
import company.dao.hibernate.EmployeeDAOHibernate;
import company.dao.interfaces.CompanyDAO;
import company.dao.interfaces.DepartmentDAO;
import company.dao.interfaces.EmployeeDAO;
import company.hibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Tobias
 */
public class HibernateDAOFactory extends DAOFactory {

    @Override
    public CompanyDAO getCompanyDAO() {
        return (CompanyDAO) instantiateDAO(CompanyDAOHibernate.class);
    }

    @Override
    public DepartmentDAO getDepartmentDAO() {
        return (DepartmentDAO) instantiateDAO(DepartmentDAOHibernate.class);
    }

    @Override
    public EmployeeDAO getEmployeeDAO() {
        return (EmployeeDAO) instantiateDAO(EmployeeDAOHibernate.class);
    }
    
    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }
    
    protected Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
}
