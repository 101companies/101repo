package beans;

import company.CompanyHelper;
import company.mapping.Department;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Tobias
 */
@ManagedBean(name="companyBean")
@SessionScoped
public class CompanyBean implements Serializable {
    
    private CompanyHelper helper;
    
    private int currentDepartment = 1;
    
    /** Creates a new instance of CompanyController */
    public CompanyBean() {
        helper = new CompanyHelper();
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
