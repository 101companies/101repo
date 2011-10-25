package company.dao.interfaces.entities;

/**
 *
 * @author Tobias
 */
public interface EmployeeInterface extends EntityInterface {
    
    public String getAddress();
    
    public void setAddress(String address);
    
    public double getSalary();
    
    public void setSalary(double salary);
    
    public boolean isManager();
    
}
