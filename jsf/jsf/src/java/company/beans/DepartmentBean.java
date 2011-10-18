package company.beans;

import company.Navigation;
import company.dao.exception.CompanyException;
import company.dao.factory.DAOFactory;
import company.dao.factory.FactoryManager;
import company.dao.interfaces.DepartmentDAO;
import company.dao.interfaces.entities.DepartmentInterface;
import company.dao.interfaces.entities.EmployeeInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import util.SelectItemComparator;

/**
 *
 * @author Tobias
 */
@ManagedBean(name="departmentBean")
@RequestScoped
public class DepartmentBean {

    private DepartmentInterface currentDepartment;
    
    private DepartmentDAO departmentDAO;
    
    private Integer nextDepartmentId = -1;
    private Integer nextEmployeeId = -1;
    
    /** Creates a new instance of DepartmentBean */
    public DepartmentBean() {
        int id;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String stringId = facesContext.getExternalContext().getRequestParameterMap().get("id");
        if (stringId != null) {
            id = Integer.parseInt(facesContext.getExternalContext().getRequestParameterMap().get("id"));
        } else {
            id = Navigation.getInstance().getNextDepartment();
        }
        
        DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
        this.departmentDAO = daoFactory.getDepartmentDAO();
        try {
            this.currentDepartment = this.departmentDAO.load(id);
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getName() {
        return this.currentDepartment.getName();
    }
    
    public void setName(String name) {
        this.currentDepartment.setName(name);
    }
    
    public Integer getDepartment() {
        return this.nextDepartmentId;
    }
    
    public void setDepartment(Integer newId) {
        this.nextDepartmentId = newId;
    }
    
    public String selectDepartment() {
        if (this.nextDepartmentId > 0) {
            Navigation.getInstance().setNextDepartment(this.nextDepartmentId);
            return "department?faces-redirect=true&amp;includeViewParams=true";
        }
        return "";
    }
    
    public List<SelectItem> getDepartments() {
        List<SelectItem> result = new ArrayList<SelectItem>();
           
        Set<DepartmentInterface> departments = this.currentDepartment.getDepartments();
        for (DepartmentInterface department : departments) {
            result.add(new SelectItem(department.getId(), department.getName()));
        }
        Collections.sort(result, new SelectItemComparator());

        return result;
    }
    
    public Integer getEmployee() {
        return this.nextEmployeeId;
    }
    
    public void setEmployee(Integer newId) {
        this.nextEmployeeId = newId;
    }
    
    public String selectEmployee() {
        if (this.nextEmployeeId > 0) {
            Navigation.getInstance().setNextEmployee(this.nextEmployeeId);
            return "employee?faces-redirect=true&amp;includeViewParams=true";
        }
        return "";
    }
    
    public List<SelectItem> getEmployees() {
        List<SelectItem> result = new ArrayList<SelectItem>();
           
        Set<EmployeeInterface> employees = this.currentDepartment.getEmployees();
        for (EmployeeInterface employee : employees) {
            result.add(new SelectItem(employee.getId(), employee.getName()));
        }
        Collections.sort(result, new SelectItemComparator());

        return result;
    }
    
    public double total() {
        try {
            return this.currentDepartment.total();
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyBean.class.getName()).log(Level.SEVERE, null, ex);
            return 0d;
        }
    }
    
    public void cut() {
        System.out.println("cut");
        try {
            this.currentDepartment.cut();
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String save() {
        try {
            DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
            DepartmentDAO dao = daoFactory.getDepartmentDAO();
            dao.update(this.currentDepartment);
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Navigation.getInstance().setNextDepartment(this.currentDepartment.getId());
        return "department?faces-redirect=true&amp;includeViewParams=true";
    }
}
