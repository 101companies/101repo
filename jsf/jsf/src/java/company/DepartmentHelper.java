package company;

import company.rdb.mapping.Department;
import company.rdb.mapping.Employee;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


/**
 *
 * @author Tobias
 */
public class DepartmentHelper {
    
    Session session = null;
    
    private Department department;

    public DepartmentHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public DepartmentHelper(int id) {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        department = getDepartment(id);
    }
    
    private Department getDepartment(int id) {
        try {
            Transaction tx = session.beginTransaction();
            Department c = (Department) session.load(Department.class, new Integer(id));
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Department> getDepartments() {
        return null;
    }
    
    public List<Employee> getEmployees() {
        return null;
    }

    public String getName() {
        return department.getName();
    }

    public void setName(String name) {
        department.setName(name);
    }

    public double total() {
        return department.total();
    }

    public void cut() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void save() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer getLowestEmployee() {
        int lowest = -1;
        
        return lowest;
    }
    
    public Integer getLowestDepartment() {
        int lowest = -1;
        
        return lowest;
    }
}
