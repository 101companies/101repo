package company.dao.rdb;

import company.dao.exception.CompanyException;
import company.dao.exception.SaveException;
import company.dao.interfaces.CompanyDAO;
import company.dao.interfaces.entities.CompanyInterface;
import company.dao.interfaces.entities.EmployeeInterface;
import company.rdb.mapping.Company;
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
public class RdbCompanyDAO implements CompanyDAO, Serializable {

    @Override
    public CompanyInterface load(int id) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Company c = (Company) session.load(Company.class, new Integer(id));
            
            return c;
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }

    @Override
    public void create(CompanyInterface company) throws CompanyException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(CompanyInterface company) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.update(company);
            tx.commit();
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }

    public void cut(CompanyInterface company) throws CompanyException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            StringBuilder queryString = new StringBuilder("SELECT department FROM Department AS department");
            queryString.append(" WHERE department.company = ");
            queryString.append(company.getId());
            queryString.append(" AND department.department IS NULL");
            
            Query query = session.createQuery(queryString.toString());
            
            List<EmployeeInterface> employees = query.list();
            for (EmployeeInterface employee : employees) {
                session.update(employee);
            }
            
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }

    
}
