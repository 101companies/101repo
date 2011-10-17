/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.interfaces.entities;

import company.dao.exception.CompanyException;
import java.util.Set;

/**
 *
 * @author Tobias
 */
public interface CompanyInterface extends EntityInterface {

    public Set<DepartmentInterface> getDepartments() throws CompanyException;
    
}
