/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.beans;

import company.Navigation;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tobias
 */
@ManagedBean(name = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    
    public int getCurrentDepartment() {
        return Navigation.getInstance().getNextDepartment();
    }

    public void setCurrentDepartment(int currentDepartment) {
        Navigation.getInstance().setNextDepartment(currentDepartment);
    }

    public int getCurrentEmployee() {
        return Navigation.getInstance().getNextEmployee();
    }

    public void setCurrentEmployee(int currentEmployee) {
        Navigation.getInstance().setNextEmployee(currentEmployee);
    }
    
    /** Creates a new instance of CompanyController */
    public NavigationBean() {
    }
}
