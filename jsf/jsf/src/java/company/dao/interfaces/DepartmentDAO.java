/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.interfaces;

import company.dao.exception.CompanyException;
import company.dao.interfaces.entities.DepartmentInterface;

/**
 *
 * @author Tobias
 */
public interface DepartmentDAO {
    
    public DepartmentInterface load(int id) throws CompanyException;
    
    public void create(DepartmentInterface department) throws CompanyException;
    
    public void update(DepartmentInterface department) throws CompanyException;
    
}
