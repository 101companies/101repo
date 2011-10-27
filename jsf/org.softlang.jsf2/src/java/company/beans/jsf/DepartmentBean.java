/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.beans.jsf;

import company.classes.Department;
import company.classes.Employee;
import company.dao.factory.DAOFactory;
import company.dao.interfaces.DepartmentDAO;
import company.hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

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
    private Long currentCompany;
    
    /** Creates a new instance of DepartmentBean */
    public DepartmentBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        String did = request.getParameter("departmentId");
        currentDepartment = Long.valueOf(did);
        String cid = request.getParameter("companyId");
        currentCompany = Long.valueOf(cid);
        
        loadDepartment(currentCompany, currentDepartment);
    }
    
    private void loadDepartment(Long cid, Long did) {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        DepartmentDAO departmentDAO = daoFactory.getDepartmentDAO();
        this.department = departmentDAO.findById(did, true);
        this.name = this.department.getName();
        
        this.departments = new ArrayList<SelectItem>();
        List<Department> depTemp = departmentDAO.findAllForDepartmentId(cid, did);
        for (Department dep : depTemp) {
            this.departments.add(new SelectItem(dep.getId(), dep.getName()));
        }
        
        this.employees = new ArrayList<SelectItem>();
        for (Employee emp : department.getEmployees()) {
           if (emp.isManager()) {
               manager = emp;
           } else {
               employees.add(new SelectItem(emp.getId(), emp.getName()));
           }
        }
        
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
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

    public Long getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(Long currentCompany) {
        this.currentCompany = currentCompany;
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
    
    public void save() {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        department.setName(this.name);
        daoFactory.getDepartmentDAO().makePersistent(department);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    }
    
}
