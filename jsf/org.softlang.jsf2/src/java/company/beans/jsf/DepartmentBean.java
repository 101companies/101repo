/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.beans.jsf;

import company.classes.Department;
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
    private double total;
    
    private Department department;
    
    private Long currentDepartment;
    
    /** Creates a new instance of DepartmentBean */
    public DepartmentBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        String id = request.getParameter("departmentId");
        currentDepartment = Long.valueOf(id);
        
        loadDepartment(currentDepartment);
    }
    
    private void loadDepartment(Long id) {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        DepartmentDAO departmentDAO = daoFactory.getDepartmentDAO();
        this.department = departmentDAO.findById(id, true);
        this.name = this.department.getName();
        
        this.departments = new ArrayList<SelectItem>();
        List<Department> depTemp = departmentDAO.findAllForDepartmentId(id);
        for (Department dep : depTemp) {
            this.departments.add(new SelectItem(dep.getId(), dep.getName()));
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
        
    public void save() {
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        department.setName(this.name);
        daoFactory.getDepartmentDAO().makePersistent(department);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    }
    
}
