/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import company.beans.CompanyBean;
import company.dao.exception.CompanyException;
import company.dao.factory.DAOFactory;
import company.dao.factory.FactoryManager;
import company.dao.interfaces.CompanyDAO;
import company.dao.interfaces.entities.CompanyInterface;
import company.dao.interfaces.entities.DepartmentInterface;
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
public class CompanyComponent extends AbstractComponent implements Serializable {

    private String name;
    
    private List<SelectItem> departments;
    
    private double total;
    
    private CompanyInterface company;
    
    public CompanyComponent() {
        System.out.println("CompanyComponent");
        try {
            DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
            CompanyDAO companyDAO = daoFactory.getCompanyDAO();
            company = companyDAO.load(1);
            
            name = company.getName();
            Set<DepartmentInterface> deps = company.getDepartments();
            departments = new ArrayList<SelectItem>();
            for (DepartmentInterface dep : deps) {
                departments.add(new SelectItem(dep.getId(), dep.getName()));
            }
            Collections.sort(departments, new SelectItemComparator());

            total = company.total();
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyComponent.class.getName()).log(Level.SEVERE, null, ex);
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
        return departments;
    }

    @Override
    public List<SelectItem> getEmployees() {
        throw new UnsupportedOperationException("Not supported by this class.");
    }

    @Override
    public void save() {
        System.out.println("save");
        try {
            DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
            CompanyDAO companyDAO = daoFactory.getCompanyDAO();
            company.setName(name);
            companyDAO.update(company);
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cut() {
        try {
            company.cut();
            total = total / 2;
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
