package company.dao.interfaces;

import company.dao.interfaces.generic.GenericDAO;
import company.classes.Department;
import java.util.List;

/**
 *
 * @author Tobias
 */
public interface DepartmentDAO extends GenericDAO<Department, Long> {
    
    public List<Department> findAllForCompanyId(Long cid);
    
    public List<Department> findAllForDepartmentId(Long cid, Long did);
            
}
