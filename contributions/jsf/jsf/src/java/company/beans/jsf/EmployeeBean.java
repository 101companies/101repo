/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.beans.jsf;

import company.classes.Employee;
import company.dao.factory.DAOFactory;
import company.dao.interfaces.EmployeeDAO;
import company.hibernate.util.HibernateUtil;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Tobias
 */
@ManagedBean
@RequestScoped
public class EmployeeBean {

    private Long currentEmployee;
    
    private String name;
    private String address;
    private double salary;
    
    private Employee employee;
    
    private Long previousDepartment;
    
    /** Creates a new instance of EmployeeBean */
    public EmployeeBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        String id = request.getParameter("employeeId");
        currentEmployee = Long.valueOf(id);
        
        loadEmployee(currentEmployee);
    }
    
    private void loadEmployee(Long id) {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        
        employee = employeeDAO.findById(id, true);
        
        name = employee.getName();
        address = employee.getAddress();
        salary = employee.getSalary();
        
        previousDepartment = employee.getDepartment().getId();
        
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Long getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(Long currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Long getPreviousDepartment() {
        return previousDepartment;
    }

    public void setPreviousDepartment(Long previousDepartment) {
        this.previousDepartment = previousDepartment;
    }
    
    public void save() {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
            employee.setName(this.name);
            employee.setAddress(this.address);
            employee.setSalary(this.salary);
            daoFactory.getEmployeeDAO().makePersistent(employee);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (ConstraintViolationException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            StringBuilder sb = new StringBuilder();
            sb.append("Error: There is already an employee with the same name and address (name = ");
            sb.append(this.name);
            sb.append(", address = ");
            sb.append(this.address);
            sb.append("). Enter valid data, please.");
            FacesMessage facesMessage = new FacesMessage(sb.toString(), "name");
            FacesContext.getCurrentInstance().addMessage("name", facesMessage);
        }
        
    }
    
    public void cut() {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        
        employee.setSalary(employee.getSalary() / 2);
        daoFactory.getEmployeeDAO().makePersistent(employee);
        
        salary = salary / 2;
        
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    }
    
}
