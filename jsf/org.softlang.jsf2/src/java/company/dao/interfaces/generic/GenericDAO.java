/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.interfaces.generic;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Tobias
 */
public interface GenericDAO<T, ID extends Serializable> {
    
    T findById(ID id, boolean lock);
    
    List<T> findAll();
 
    List<T> findByExample(T exampleInstance);
 
    T makePersistent(T entity);
 
    void makeTransient(T entity);
}
