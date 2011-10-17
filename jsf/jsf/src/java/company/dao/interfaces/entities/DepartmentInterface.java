/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.interfaces.entities;

import java.util.Set;

/**
 *
 * @author Tobias
 */
public interface DepartmentInterface extends EntityInterface {
        
    public Set<DepartmentInterface> getDepartments();
    
    public Set<EmployeeInterface> getEmployees();

}
