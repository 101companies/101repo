/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.factory;

/**
 *
 * @author Tobias
 */
public class FactoryManager {
    
    private static FactoryManager singleton;
    private DAOFactory daoFactory = new RdbDAOFactory();
    
    private FactoryManager() {
        this.daoFactory = new RdbDAOFactory();
    }
    
    public static FactoryManager getInstance() {
        if (singleton == null) {
            singleton = new FactoryManager();
        }
        return singleton;
    }

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }

}
