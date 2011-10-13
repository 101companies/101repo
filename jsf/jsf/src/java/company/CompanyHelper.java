package company;

import company.mapping.Company;
import company.mapping.Department;
import company.mapping.Employee;
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
public class CompanyHelper {
    
    Session session = null;
    
    Company company;
    
    public CompanyHelper() {
        this.company = getCompany(1);
    }
    
    private Company getCompany(int id) {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Company c = (Company) session.load(Company.class, new Integer(id));
            
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getName() {
        return company.getName();
    }
    
    public void setName(String name) {
        company.setName(name);
    }

    public double total() {
        return company.total();
    }

    public List<Department> getDepartments() {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            StringBuilder query = new StringBuilder("SELECT department FROM Department AS department");
            query.append(" WHERE department.company = ");
            query.append(company.getId());
            query.append(" AND department.department IS NULL");
            Query q = session.createQuery(query.toString());
            
            return q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void cut() {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            for (Employee employee : company.getEmployees()) {
                employee.setSalary(employee.getSalary() / 2);
                session.update(employee);
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void save() {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.refresh(company);
            session.update(company);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
