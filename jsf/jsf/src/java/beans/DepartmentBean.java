/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import company.DepartmentHelper;
import company.mapping.Department;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Tobias
 */
@ManagedBean
@SessionScoped
public class DepartmentBean {

    DepartmentHelper helper;
    
    private int currentDepartment = 1;
    private int currentEmployee = 1;
    
    int id;
    
    /** Creates a new instance of DepartmentBean */
    public DepartmentBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
            id = Integer.parseInt(facesContext.getExternalContext().getRequestParameterMap().get("id"));
            helper = new DepartmentHelper(id);
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return helper.getName();
    }
    
    public void setName(String name) {
        helper.setName(name);
    }
    
    public boolean isDepartmentSelected() {
        return currentDepartment < 1;
    }
    
    public int getDepartment() {
        List<Department> deps = helper.getDepartments();
        if (deps.isEmpty()) {
            currentDepartment = -1;
            return -1;
        } else {
            return currentDepartment;
        }
    }
    
    public void setDepartment(int id) {
        currentDepartment = id;
    }
    
    public List<SelectItem> getDepartments() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        for (Department department : helper.getDepartments()) {
            result.add(new SelectItem(department.getId(), department.getName()));
        }
        return result;
    }
}
