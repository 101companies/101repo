/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import company.dao.exception.CompanyException;
import company.dao.factory.DAOFactory;
import company.dao.factory.FactoryManager;
import company.dao.interfaces.DepartmentDAO;
import company.dao.interfaces.entities.DepartmentInterface;
import company.dao.interfaces.entities.EmployeeInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import util.SelectItemComparator;

/**
 *
 * @author Tobias
 */
public class DepartmentComponent extends AbstractComponent implements Serializable {

    private String name;
    
    private List<SelectItem> departments;
    private List<SelectItem> employees;
    
    private double total;
    
    private DepartmentInterface department;
    
    private EmployeeInterface manager;
    
    public DepartmentComponent(int id) {
        try {
            DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
            DepartmentDAO departmentDAO = daoFactory.getDepartmentDAO();
            department = departmentDAO.load(id);
            
            name = department.getName();
            
            Set<DepartmentInterface> deps = department.getDepartments();
            departments = new ArrayList<SelectItem>();
            for (DepartmentInterface dep : deps) {
                departments.add(new SelectItem(dep.getId(), dep.getName()));
            }
            Collections.sort(departments, new SelectItemComparator());
            
            Set<EmployeeInterface> emps = department.getEmployees();
            employees = new ArrayList<SelectItem>();
            for (EmployeeInterface emp : emps) {
                if (emp.isManager()) {
                    manager = emp;
                } else {
                    employees.add(new SelectItem(emp.getId(), emp.getName()));
                }
            }
            Collections.sort(employees, new SelectItemComparator());

            total = department.total();
        } catch (CompanyException ex) {
            Logger.getLogger(DepartmentComponent.class.getName()).log(Level.SEVERE, null, ex);
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
        throw new UnsupportedOperationException("Not supported by this class.");
    }

    @Override
    public void setAddress(String address) {
        throw new UnsupportedOperationException("Not supported by this class.");
    }

    @Override
    public double getTotal() {
        return this.total;
    }

    @Override
    public List<SelectItem> getDepartments() {
        return this.departments;
    }

    @Override
    public List<SelectItem> getEmployees() {
        return this.employees;
    }

    @Override
    public void save() {
        try {
            DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
            DepartmentDAO departmentDAO = daoFactory.getDepartmentDAO();
            department.setName(name);
            departmentDAO.update(department);
        } catch (CompanyException ex) {
            Logger.getLogger(DepartmentComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cut() {
        try {
            department.cut();
            total = total / 2;
        } catch (CompanyException ex) {
            Logger.getLogger(DepartmentComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getId() {
        return department.getId();
    }

    @Override
    public String getManager() {
        return this.manager.getName();
    }

    public Integer getManagerId() {
        return this.manager.getId();
    }
    
}
