package company.dao.factory;

import company.dao.interfaces.CompanyDAO;
import company.dao.interfaces.DepartmentDAO;
import company.dao.interfaces.EmployeeDAO;

/**
 *
 * @author Tobias
 */
public interface DAOFactory {
    
    public CompanyDAO getCompanyDAO();
    
    public DepartmentDAO getDepartmentDAO();
    
    public EmployeeDAO getEmployeeDAO();
    
}
