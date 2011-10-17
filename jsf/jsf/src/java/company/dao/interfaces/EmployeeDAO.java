/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.interfaces;

import company.dao.exception.CompanyException;
import company.dao.interfaces.entities.EmployeeInterface;

/**
 *
 * @author Tobias
 */
public interface EmployeeDAO {
    
    public EmployeeInterface load(int id) throws CompanyException;
    
    public void create(EmployeeInterface employee) throws CompanyException;
    
    public void update(EmployeeInterface employee) throws CompanyException;
    
}
