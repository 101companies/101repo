package company.dao.rdb;

import company.dao.exception.CompanyException;
import company.dao.interfaces.DepartmentDAO;
import company.dao.interfaces.entities.DepartmentInterface;
import company.rdb.mapping.Department;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Tobias
 */
public class RdbDepartmentDAO implements DepartmentDAO, Serializable {

    @Override
    public DepartmentInterface load(int id) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Department d = (Department) session.load(Department.class, new Integer(id));
            
            return d;
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }

    @Override
    public void create(DepartmentInterface department) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(DepartmentInterface department) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.update(department);
            tx.commit();
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }

    public void cut(DepartmentInterface department) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<DepartmentInterface> loadDepartmentsForCompany(int id) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            StringBuilder queryString = new StringBuilder("SELECT department FROM Department AS department");
            queryString.append(" WHERE department.company = ");
            queryString.append(id);
            queryString.append(" AND department.department IS NULL");
            
            Query query = session.createQuery(queryString.toString());
            return query.list();
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }

     
}
