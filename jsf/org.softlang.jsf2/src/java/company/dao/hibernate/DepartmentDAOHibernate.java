package company.dao.hibernate;

import company.dao.hibernate.generic.GenericHibernateDAO;
import company.dao.interfaces.DepartmentDAO;
import company.classes.Department;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Tobias
 */
public class DepartmentDAOHibernate
        extends GenericHibernateDAO<Department, Long>
        implements DepartmentDAO {
    
    @Override
    public List<Department> findAllForCompanyId(Long id) {
        StringBuilder queryString = new StringBuilder("SELECT department FROM Department AS department");
        queryString.append(" WHERE department.company = ");
        queryString.append(id);
        queryString.append(" AND department.department IS NULL");
        
        Query query = getSession().createQuery(queryString.toString());
        
        return query.list();
    }

    @Override
    public List<Department> findAllForDepartmentId(Long id) {
        StringBuilder queryString = new StringBuilder("SELECT department FROM Department AS department");
        queryString.append(" WHERE department.department = ");
        queryString.append(id);
        
        Query query = getSession().createQuery(queryString.toString());
        
        return query.list();
    }
    
    
}
