package company.dao.rdb;

import company.dao.exception.CompanyException;
import company.dao.interfaces.CompanyDAO;
import company.dao.interfaces.entities.CompanyInterface;
import company.rdb.mapping.Company;
import java.io.Serializable;
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
            
            company.getName();
            
            session.update(company);
            tx.commit();
        } catch (Exception e) {
            throw new CompanyException(e.getMessage());
        }
    }    
}
