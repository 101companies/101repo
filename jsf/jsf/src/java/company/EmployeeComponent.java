/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import company.dao.exception.CompanyException;
import company.dao.factory.DAOFactory;
import company.dao.factory.FactoryManager;
import company.dao.interfaces.EmployeeDAO;
import company.dao.interfaces.entities.EmployeeInterface;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;

/**
 *
 * @author Tobias
 */
public class EmployeeComponent extends AbstractComponent implements Serializable {

    private String name;
    private String address;
    private double salary;
    
    private EmployeeInterface employee;
    
    public EmployeeComponent(int id) {
        try {
            DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
            EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
            employee = employeeDAO.load(id);
            
            name = employee.getName();
            address = employee.getAddress();
            salary = employee.getSalary();
        } catch (CompanyException ex) {
            Logger.getLogger(EmployeeComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public double getTotal() {
        return this.salary;
    }

    @Override
    public List<SelectItem> getDepartments() {
        throw new UnsupportedOperationException("Not supported by this class.");
    }

    @Override
    public List<SelectItem> getEmployees() {
        throw new UnsupportedOperationException("Not supported by this class.");
    }

    @Override
    public void save() {
        try {
            DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
            EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
            employee.setName(name);
            employeeDAO.update(employee);
        } catch (CompanyException ex) {
            Logger.getLogger(EmployeeComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cut() {
        try {
            employee.cut();
            salary = salary / 2;
        } catch (CompanyException ex) {
            Logger.getLogger(EmployeeComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
