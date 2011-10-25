package company.dao.rdb;

import company.dao.exception.CompanyException;
import company.dao.exception.SaveException;
import company.dao.exception.constants.Field;
import company.dao.interfaces.EmployeeDAO;
import company.dao.interfaces.entities.EmployeeInterface;
import company.rdb.mapping.Employee;
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
public class RdbEmployeeDAO implements EmployeeDAO, Serializable {

    @Override
    public EmployeeInterface load(int id) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Employee e = (Employee) session.load(Employee.class, new Integer(id));
            
            return e;
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }

    @Override
    public void create(EmployeeInterface employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(EmployeeInterface employee) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.merge(employee);
            tx.commit();
        } catch (Exception e) {
            throw new SaveException(Field.name, e.getMessage());
        }
    }

    public List<EmployeeInterface> loadEmployeesForCompany(int id) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            StringBuilder queryString = new StringBuilder("SELECT employee FROM Employee AS employee");
            queryString.append(" WHERE employee.company = ");
            queryString.append(id);
            
            Query query = session.createQuery(queryString.toString());
            return query.list();
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }

    public List<EmployeeInterface> loadEmployeesForDepartment(Integer id) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            StringBuilder queryString = new StringBuilder("SELECT employee FROM Employee AS employee");
            queryString.append(" WHERE employee.department = ");
            queryString.append(id);
            
            Query query = session.createQuery(queryString.toString());
            return query.list();
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }
}
