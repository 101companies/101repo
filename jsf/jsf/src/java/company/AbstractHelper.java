/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.io.Serializable;

/**
 *
 * @author Tobias
 */
public abstract class AbstractHelper implements Serializable {
    
    public abstract String getName();
    
    public abstract void setName(String name);
    
    public abstract double total();
    
    public abstract void cut();
    
    public abstract void save();
}
