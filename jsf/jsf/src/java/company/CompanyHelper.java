package company;

import company.mapping.Company;
import company.mapping.Department;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Tobias
 */
public class CompanyHelper extends AbstractDepartmentListHelper {
    
    Session session = null;
    
    Company company;
    
    public CompanyHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        this.company = getCompany(1);
    }
    
    private Company getCompany(int id) {
        try {
            Transaction tx = session.beginTransaction();
            Company c = (Company) session.load(Company.class, new Integer(id));
            return c;
        } catch (Exception e) {
            // TODO
        }
        return null;
    }
    
    @Override
    public String getName() {
        return company.getName();
    }
    
    @Override
    public void setName(String name) {
        company.setName(name);
    }

    @Override
    public double total() {
        return company.total();
    }

    @Override
    public List<Department> getDepartments() {
        try {
            Transaction tx = session.beginTransaction();
            StringBuilder query = new StringBuilder("SELECT department FROM Department AS department");
            query.append(" WHERE department.company = ");
            query.append(company.getId());
            query.append(" AND department.department IS NULL");
            Query q = session.createQuery(query.toString());
            
            return q.list();
        } catch (Exception e) {
            // TODO
        }
        return null;
    }
    
    @Override
    public void cut() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
