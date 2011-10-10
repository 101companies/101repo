package company;

import company.mapping.Department;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


/**
 *
 * @author Tobias
 */
public class DepartmentHelper extends AbstractDepartmentListHelper {
    
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
            // TODO
        }
        return null;
    }

    @Override
    public List<Department> getDepartments() {
        return new ArrayList<Department>(department.getDepartments());
    }

    @Override
    public String getName() {
        return department.getName();
    }

    @Override
    public void setName(String name) {
        department.setName(name);
    }

    @Override
    public double total() {
        return 0;
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
