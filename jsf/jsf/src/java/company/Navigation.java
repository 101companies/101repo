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
    
    private int currentDepartment;
    private int currentEmployee;

    private static Navigation singleton;
    
    private Navigation() {
        
    }

    public int getCurrentDepartment() {
        return currentDepartment;
    }

    public void setCurrentDepartment(int currentDepartment) {
        this.currentDepartment = currentDepartment;
    }

    public int getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(int currentEmployee) {
        this.currentEmployee = currentEmployee;
    }
    
    public static Navigation getInstance() {
        if (singleton == null) {
            singleton = new Navigation();
        }
        return singleton;
    }
}
