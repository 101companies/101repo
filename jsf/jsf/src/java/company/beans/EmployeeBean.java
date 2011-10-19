/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.beans;

import company.Navigation;
import company.dao.exception.CompanyException;
import company.dao.factory.DAOFactory;
import company.dao.factory.FactoryManager;
import company.dao.interfaces.EmployeeDAO;
import company.dao.interfaces.entities.EmployeeInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tobias
 */
@ManagedBean(name = "employeeBean")
@RequestScoped
public class EmployeeBean {

    private EmployeeInterface currentEmployee;
    
    private EmployeeDAO employeeDAO;
    
    /** Creates a new instance of EmployeeBean */
    public EmployeeBean() {
        int id;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String stringId = facesContext.getExternalContext().getRequestParameterMap().get("id");
        if (stringId != null) {
            id = Integer.parseInt(facesContext.getExternalContext().getRequestParameterMap().get("id"));
        } else {
            id = Navigation.getInstance().getNextDepartment();
        }
        
        DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
        this.employeeDAO = daoFactory.getEmployeeDAO();
        try {
            this.currentEmployee = this.employeeDAO.load(id);
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getName() {
        return this.currentEmployee.getName();
    }
    
    public void setName(String name) {
        this.currentEmployee.setName(name);
    }
    
    public String getAddress() {
        return this.currentEmployee.getAddress();
    }
    
    public void setAddress(String address) {
        this.currentEmployee.setAddress(address);
    }
    
    public double getSalary() {
        return this.currentEmployee.getSalary();
    }
    
    public void setSalary(double salary) {
        this.currentEmployee.setSalary(salary);
    }
    
    public void cut() {
        System.out.println("cut");
        try {
            this.currentEmployee.cut();
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void save() {
        try {
            DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
            EmployeeDAO dao = daoFactory.getEmployeeDAO();
            dao.update(this.currentEmployee);
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
