package beans;

import company.CompanyHelper;
import company.Navigation;
import company.mapping.Department;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import util.SelectItemComparator;

/**
 *
 * @author Tobias
 */
@ManagedBean(name="companyBean")
@SessionScoped
public class CompanyBean implements Serializable {
    
    private CompanyHelper helper;
    
    int nextDepartment;
    
    
    /** Creates a new instance of CompanyController */
    public CompanyBean() {
        helper = new CompanyHelper();
    }

    public String getName() {
        return helper.getName();
    }
    
    public void setName(String name) {
        System.out.println(name);
        helper.setName(name);
    }
    
    public boolean isDepartmentSelectDisabled() {
        return helper.getDepartments().isEmpty();
    }
    
    public int getDepartment() {
        List<Department> deps = helper.getDepartments();
        if (deps.isEmpty()) {
            return -1;
        } else {
            nextDepartment = helper.getDepartments().get(0).getId();
            return nextDepartment;
        }
    }
    
    public void setDepartment(int newId) {
        nextDepartment = newId;
    }
    
    public String selectDepartment() {
        Navigation.getInstance().setCurrentDepartment(nextDepartment);
        return "department?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public List<SelectItem> getDepartments() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        for (Department department : helper.getDepartments()) {
            result.add(new SelectItem(department.getId(), department.getName()));
        }
        Collections.sort(result, new SelectItemComparator());
        return result;
    }
    
    public double getTotal() {
        return helper.total();
    }
    
    public void cut() {
        helper.cut();
    }
    
    public void save() {
        helper.save();
    }
}
