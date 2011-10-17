/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import company.Navigation;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tobias
 */
@ManagedBean(name = "companyController")
@SessionScoped
public class CompanyController implements Serializable {

    
    public int getCurrentDepartment() {
        return Navigation.getInstance().getCurrentDepartment();
    }

    public void setCurrentDepartment(int currentDepartment) {
        Navigation.getInstance().setCurrentDepartment(currentDepartment);
    }

    public int getCurrentEmployee() {
        return Navigation.getInstance().getCurrentEmployee();
    }

    public void setCurrentEmployee(int currentEmployee) {
        Navigation.getInstance().setCurrentEmployee(currentEmployee);
    }
    
    /** Creates a new instance of CompanyController */
    public CompanyController() {
    }
}
