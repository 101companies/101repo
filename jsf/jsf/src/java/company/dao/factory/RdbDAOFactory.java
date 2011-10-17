package company.dao.factory;

import company.dao.interfaces.CompanyDAO;
import company.dao.interfaces.DepartmentDAO;
import company.dao.interfaces.EmployeeDAO;
import company.dao.rdb.RdbCompanyDAO;
import company.dao.rdb.RdbDepartmentDAO;
import company.dao.rdb.RdbEmployeeDAO;

/**
 *
 * @author Tobias
 */
public class RdbDAOFactory implements DAOFactory {
    
    @Override
    public CompanyDAO getCompanyDAO() {
        return new RdbCompanyDAO();
    }

    @Override
    public DepartmentDAO getDepartmentDAO() {
        return new RdbDepartmentDAO();
    }

    @Override
    public EmployeeDAO getEmployeeDAO() {
        return new RdbEmployeeDAO();
    }
    
}
