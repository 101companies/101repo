package company;

import company.rdb.mapping.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


/**
 *
 * @author Tobias
 */
public class EmployeeHelper {

    Session session = null;
    
    Employee employee;
    
    public EmployeeHelper(int id) {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        this.employee = getEmployee(id);
    }
    
    private Employee getEmployee(int id) {
        try {
            Transaction tx = session.beginTransaction();
            Employee e = (Employee) session.load(Employee.class, new Integer(id));
            return e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return employee.getName();
    }

    public void setName(String name) {
        employee.setName(name);
    }
    
    public String getAddress() {
        return employee.getAddress();
    }

    public double total() {
        return employee.getSalary();
    }

    public void cut() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void save() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
