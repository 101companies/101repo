package beans;

import company.AbstractDepartmentListHelper;
import company.AbstractHelper;
import company.CompanyHelper;
import company.mapping.Company;
import company.mapping.Department;
import company.mapping.Employee;
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
@ManagedBean(name="companyController")
@SessionScoped
public class CompanyController implements Serializable {

    Company currentCompany;
    Department currentDepartment;
    Employee currentEmployee;
    
    private AbstractHelper helper;
    
    /** Creates a new instance of CompanyController */
    public CompanyController() {
        helper = new CompanyHelper();
    }
    
    public String getName() {
        return helper.getName();
    }
    
    public void setName(String name) {
        helper.setName(name);
    }
    
    public List<SelectItem> getDepartments() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        for (Department department : ((AbstractDepartmentListHelper) helper).getDepartments()) {
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
