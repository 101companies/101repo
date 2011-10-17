/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import company.DepartmentHelper;
import company.Navigation;
import company.mapping.Department;
import company.mapping.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public class DepartmentBean implements Serializable {

    DepartmentHelper helper;
    
    int id;
    
    Integer nextDepartment;
    Integer nextEmployee;
    
    /** Creates a new instance of DepartmentBean */
    public DepartmentBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String stringId = facesContext.getExternalContext().getRequestParameterMap().get("id");
        if (stringId != null) {
            id = Integer.parseInt(facesContext.getExternalContext().getRequestParameterMap().get("id"));
        } else {
            id = Navigation.getInstance().getCurrentDepartment();
        }
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
    
    public boolean isDepartmentSelectDisabled() {
        return helper.getDepartments().isEmpty();
    }
    
    public boolean isEmployeeSelectDisabled() {
        return helper.getEmployees().isEmpty();
    }
    
    public Integer getDepartment() {
        List<Department> deps = helper.getDepartments();
        if (deps.isEmpty()) {
            return -1;
        } else {
            nextDepartment = helper.getDepartments().get(0).getId();
            return nextDepartment;
        }
    }
    
    public Integer getEmployee() {
        List<Employee> deps = helper.getEmployees();
        if (deps.isEmpty()) {
            return -1;
        } else {
            nextEmployee = helper.getLowestEmployee();
            return nextEmployee;
        }
    }
    
    public void setDepartment(Integer newId) {
        nextDepartment = newId;
    }
    
    public void setEmployee(Integer newId) {
        nextEmployee = newId;
    }
    
    public String selectDepartment() {
        Navigation.getInstance().setCurrentDepartment(nextDepartment);
        return "department?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public String selectEmployee() {
        Navigation.getInstance().setCurrentEmployee(nextEmployee);
        return "employee?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public List<SelectItem> getDepartments() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        for (Department department : helper.getDepartments()) {
            result.add(new SelectItem(department.getId(), department.getName()));
        }
        Collections.sort(result, new SelectItemComparator());
        return result;
    }
    
    public List<SelectItem> getEmployees() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        for (Employee employee : helper.getEmployees()) {
            result.add(new SelectItem(employee.getId(), employee.getName()));
        }
        Collections.sort(result, new SelectItemComparator());
        return result;
    }
    
    public double getTotal() {
        return helper.total();
    }
    
    public String cut() {
        helper.cut();
        return "department?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public String save() {
        helper.save();
        return "department?faces-redirect=true&amp;includeViewParams=true";
    }
}
