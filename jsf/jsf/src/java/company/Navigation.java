/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

/**
 *
 * @author Tobias
 */
public class Navigation {
    
    private int nextDepartment;
    private int nextEmployee;

    private static Navigation singleton;
    
    private Navigation() {
        
    }

    public int getNextDepartment() {
        return nextDepartment;
    }

    public void setNextDepartment(int nextDepartment) {
        this.nextDepartment = nextDepartment;
    }

    public int getNextEmployee() {
        return nextEmployee;
    }

    public void setNextEmployee(int nextEmployee) {
        this.nextEmployee = nextEmployee;
    }
    
    public static Navigation getInstance() {
        if (singleton == null) {
            singleton = new Navigation();
        }
        return singleton;
    }
}
