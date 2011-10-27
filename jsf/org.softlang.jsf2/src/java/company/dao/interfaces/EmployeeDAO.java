package company.dao.interfaces;

import company.dao.interfaces.generic.GenericDAO;
import company.hibernate.mapping.Employee;

/**
 *
 * @author Tobias
 */
public interface EmployeeDAO extends GenericDAO<Employee, Long> {
    
}
