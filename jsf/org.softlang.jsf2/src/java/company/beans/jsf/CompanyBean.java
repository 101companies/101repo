/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.beans.jsf;

import company.dao.factory.DAOFactory;
import company.dao.interfaces.EmployeeDAO;
import company.classes.Company;
import company.classes.Department;
import company.classes.Employee;
import company.hibernate.util.HibernateUtil;
import java.util.ArrayList;
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
    
    private Company company;
    
    private Long departmentId;
    
    /** Creates a new instance of CompanyBean */
    public CompanyBean() {
        loadCompany(Long.valueOf(1));
    }
    
    private void loadCompany(Long id) {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        company = daoFactory.getCompanyDAO().findById(id, true);
        name = company.getName();
        
        employees = company.getEmployees();
        total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        
        departments = new ArrayList<SelectItem>();
        List<Department> depTemp = daoFactory.getDepartmentDAO().findAllForCompanyId(id);
        for (Department dep : depTemp) {
            departments.add(new SelectItem(dep.getId(), dep.getName()));
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
    
    public void save() {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        company.setName(this.name);
        daoFactory.getCompanyDAO().makePersistent(company);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    }
    
    public Long getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

}
