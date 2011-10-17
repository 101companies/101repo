/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.interfaces.entities;

import company.dao.exception.CompanyException;

/**
 *
 * @author Tobias
 */
public interface EntityInterface {
    
    public Integer getId();
    
    public String getName();
    
    public void setName(String name);
    
    public double total() throws CompanyException;
    
    public void cut() throws CompanyException;
    
}
