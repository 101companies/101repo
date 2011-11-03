/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.factory;

import company.dao.factory.hibernate.HibernateDAOFactory;
import company.dao.interfaces.CompanyDAO;
import company.dao.interfaces.DepartmentDAO;
import company.dao.interfaces.EmployeeDAO;

/**
 *
 * @author Tobias
 */
public abstract class DAOFactory {
    
    public static final Class HIBERNATE = HibernateDAOFactory.class;
 
    /**
     * Factory method for instantiation of concrete factories.
     */
    public static DAOFactory instance(Class factory) {
        try {
            return (DAOFactory) factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }
    
    public abstract CompanyDAO getCompanyDAO();
    
    public abstract DepartmentDAO getDepartmentDAO();
    
    public abstract EmployeeDAO getEmployeeDAO();
    
}
