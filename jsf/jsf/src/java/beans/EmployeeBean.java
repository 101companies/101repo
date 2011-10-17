package beans;

import company.EmployeeHelper;
import company.Navigation;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tobias
 */
@ManagedBean(name = "employeeBean")
@RequestScoped
public class EmployeeBean implements Serializable {

    EmployeeHelper helper;
    
    int id;
    
    /** Creates a new instance of EmployeeBean */
    public EmployeeBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String stringId = facesContext.getExternalContext().getRequestParameterMap().get("id");
        if (stringId != null) {
            id = Integer.parseInt(facesContext.getExternalContext().getRequestParameterMap().get("id"));
        } else {
            id = Navigation.getInstance().getCurrentEmployee();
        }
        helper = new EmployeeHelper(id);
    }
    
    public String getName() {
        return helper.getName();
    }
    
    public String getAddress() {
        return helper.getAddress();
    }
    
    public double total() {
        return helper.total();
    }
}
