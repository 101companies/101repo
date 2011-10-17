package company.beans;

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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import util.SelectItemComparator;

/**
 *
 * @author Tobias
 */
@ManagedBean(name = "companyController")
@SessionScoped
public class CompanyController implements Serializable {
    
    private CompanyInterface currentCompany;
    
    private CompanyDAO companyDAO;

    /** Creates a new instance of CompanyController */
    public CompanyController() {
        DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
        this.companyDAO = daoFactory.getCompanyDAO();
        try {
            this.currentCompany = this.companyDAO.load(1);
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getName() {
        return this.currentCompany.getName();
    }
    
    public void setName(String name) {
        this.currentCompany.setName(name);
    }
    
    public List<SelectItem> getDepartments() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        try {
            
            Set<DepartmentInterface> departments = this.currentCompany.getDepartments();
            for (DepartmentInterface department : departments) {
                result.add(new SelectItem(department.getId(), department.getName()));
            }
            Collections.sort(result, new SelectItemComparator());

        } catch (CompanyException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public double total() {
        try {
            return this.currentCompany.total();
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
            return 0d;
        }
    }
    
    public void cut() {
        try {
            this.currentCompany.cut();
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void save() {
        try {
            DAOFactory daoFactory = FactoryManager.getInstance().getDaoFactory();
            CompanyDAO dao = daoFactory.getCompanyDAO();
            dao.update(currentCompany);
        } catch (CompanyException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
