package company;

import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Tobias
 */
public abstract class AbstractComponent {
    
    public abstract String getName();
    
    public abstract void setName(String name);
    
    public abstract String getAddress();
    
    public abstract void setAddress(String address);
    
    public abstract double getTotal();
    
    public abstract void setTotal(double total);
    
    public abstract String getManager();
    
    public abstract List<SelectItem> getDepartments();
    
    public abstract List<SelectItem> getEmployees();
    
    public abstract void save();
    
    public abstract void cut();
    
    public abstract void refresh();
}
