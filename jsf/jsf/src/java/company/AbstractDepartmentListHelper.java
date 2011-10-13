/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import company.mapping.Department;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Tobias
 */
public abstract class AbstractDepartmentListHelper extends AbstractHelper implements Serializable {
    
    public abstract List<Department> getDepartments();

}
