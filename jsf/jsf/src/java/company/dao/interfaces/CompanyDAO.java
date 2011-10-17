/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.interfaces;

import company.dao.exception.CompanyException;
import company.dao.interfaces.entities.CompanyInterface;

/**
 *
 * @author Tobias
 */
public interface CompanyDAO {
    
    public CompanyInterface load(int id) throws CompanyException;
    
    public void create(CompanyInterface company) throws CompanyException;
    
    public void update(CompanyInterface company) throws CompanyException;
    
}
