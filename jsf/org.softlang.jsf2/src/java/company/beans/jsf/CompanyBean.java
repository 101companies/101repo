/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.beans.jsf;

import company.dao.factory.DAOFactory;
import company.dao.interfaces.EmployeeDAO;
import company.hibernate.mapping.Company;
import company.hibernate.mapping.Employee;
import company.hibernate.util.HibernateUtil;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Tobias
 */
@ManagedBean(name = "companyBean")
@RequestScoped
public class CompanyBean {
    
    private String name;
    private List<SelectItem> departments;
    private Set<Employee> employees;
    private double total;
    
    /** Creates a new instance of CompanyBean */
    public CompanyBean() {
        //http://community.jboss.org/wiki/GenericDataAccessObjects
        loadCompany(Long.valueOf(1));
    }
    
    
    private void loadCompany(Long id) {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        Company company = daoFactory.getCompanyDAO().findById(id, true);
        name = company.getName();
        
        employees = company.getEmployees();
        total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SelectItem> getDepartments() {
        return departments;
    }

    public double getTotal() {
        return total;
    }

    public void cut() {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() / 2);
            employeeDAO.makePersistent(employee);
        }
        
        total = total / 2;
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    }
    
    public boolean isBackDisabled() {
        return true;
    }
}
