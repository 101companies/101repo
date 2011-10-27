package company.beans.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tobias
 */
@ManagedBean(name = "navigation")
@SessionScoped
public class Navigation {
    
    private Long currentDepartment;
    private Long currentEmployee;
    
    public Navigation() {}
    
    public Long getCurrentDepartment() {
        return Long.valueOf(2);
    }

    public void setCurrentDepartment(Long currentDepartment) {
        System.out.println("setCurrentDepartment");
        this.currentDepartment = currentDepartment;
    }

    public Long getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(Long currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

}
