/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.beans.jsf;

import company.classes.Department;
import company.classes.Employee;
import company.dao.factory.DAOFactory;
import company.dao.interfaces.DepartmentDAO;
import company.dao.interfaces.EmployeeDAO;
import company.hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Tobias
 */
@ManagedBean
@RequestScoped
public class DepartmentBean {
    
    private String name;
    private List<SelectItem> departments;
    private List<SelectItem> employees;
    private Employee manager;
    private double total;
    
    private Department department;
    
    private Long currentDepartment;
    
    private Long nextDepartment;
    private Long previousDepartment;
    
    private Long nextEmployee;
    
    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;
    
    /** Creates a new instance of DepartmentBean */
    public DepartmentBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        String did = request.getParameter("departmentId");
        currentDepartment = Long.valueOf(did);
        
        loadDepartment(currentDepartment);
    }
    
    private void loadDepartment(Long did) {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        this.departmentDAO = daoFactory.getDepartmentDAO();
        this.department = departmentDAO.findById(did, true);
        this.name = this.department.getName();
        
        if (department.getDepartment() == null) {
            previousDepartment = null;
        } else {
            previousDepartment = department.getDepartment().getId();
        }
        
        total = 0;
        
        this.departments = new ArrayList<SelectItem>();
        for (Department dep : department.getDepartments()) {
            this.departments.add(new SelectItem(dep.getId(), dep.getName()));
            total += total(dep);
        }
        
        this.employees = new ArrayList<SelectItem>();
        for (Employee emp : department.getEmployees()) {
            total += emp.getSalary();
           if (emp.isManager()) {
               manager = emp;
           } else {
               employees.add(new SelectItem(emp.getId(), emp.getName()));
           }
        }
        
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    }
    
    private double total(Department dep) {
        double totalTemp = 0;
        List<Department> depsTemp = departmentDAO.findAllForDepartmentId(dep.getId());
        for (Department depTemp : depsTemp) {
            totalTemp += total(depTemp);
        }
        for (Employee emp : dep.getEmployees()) {
            totalTemp += emp.getSalary();
        }
        return totalTemp;
    }
    
    private void cut(Department dep) {
        List<Department> depsTemp = departmentDAO.findAllForDepartmentId(dep.getId());
        for (Department depTemp : depsTemp) {
            cut(depTemp);
        }
        for (Employee emp : dep.getEmployees()) {
            emp.setSalary(emp.getSalary() / 2);
            employeeDAO.makePersistent(emp);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCurrentDepartment() {
        return currentDepartment;
    }

    public void setCurrentDepartment(Long currentDepartment) {
        this.currentDepartment = currentDepartment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<SelectItem> getDepartments() {
        return departments;
    }

    public List<SelectItem> getEmployees() {
        return employees;
    }

    public String getManagerName() {
        return manager.getName();
    }

    public Long getNextDepartment() {
        return nextDepartment;
    }

    public void setNextDepartment(Long departmentId) {
        this.nextDepartment = departmentId;
    }

    public Long getNextEmployee() {
        return nextEmployee;
    }

    public void setNextEmployee(Long nextEmployee) {
        this.nextEmployee = nextEmployee;
    }
    
    public String back() {
        if (previousDepartment == null) {
            return "backToCompany";
        } else {
            return "backToDepartment";
        }
    }
    
    public Long getPreviousDepartment() {
        return previousDepartment;
    }

    public void setPreviousDepartment(Long previousDepartment) {
        this.previousDepartment = previousDepartment;
    }

    public double getTotal() {
        return total;
    }
    
    public void selectManager() {
        nextEmployee = manager.getId();
    }
    
    public void save() {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
            department.setName(this.name);
            daoFactory.getDepartmentDAO().makePersistent(department);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (ConstraintViolationException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            StringBuilder sb = new StringBuilder();
            sb.append("Error: There is already a department with the name ");
            sb.append(this.name);
            sb.append(". Enter a valid name, please.");
            FacesMessage facesMessage = new FacesMessage(sb.toString(), "name");
            FacesContext.getCurrentInstance().addMessage("name", facesMessage);
        }
        
    }
    
    public void cut() {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        this.departmentDAO = daoFactory.getDepartmentDAO();
        this.employeeDAO = daoFactory.getEmployeeDAO();
        
        for (Department dep : department.getDepartments()) {
            cut(dep);
        }
        
        for (Employee emp : department.getEmployees()) {
            emp.setSalary(emp.getSalary() / 2);
            employeeDAO.makePersistent(emp);
        }
        
        total = total / 2;
        
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    }
    
}
