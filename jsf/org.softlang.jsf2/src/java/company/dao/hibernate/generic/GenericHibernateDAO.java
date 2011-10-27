/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package company.dao.hibernate.generic;

import company.dao.interfaces.generic.GenericDAO;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author Tobias
 */
public class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private Class<T> persistentClass;
    private Session session;
    
    public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public void setSession(Session s) {
        this.session = s;
    }
    
    protected Session getSession() {
        if (session == null)
            throw new IllegalStateException("Session has not been set on DAO before usage");
        return session;
    }
    
    public Class<T> getPersistentClass() {
        return persistentClass;
    }
    
    @Override
    public T findById(ID id, boolean lock) {
        T entity;
        if (lock) {
            entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
        } else {
            entity = (T) getSession().load(getPersistentClass(), id);
        }
        return entity;
    }

    @Override
    public List<T> findAll() {
        return findByCriteria();
    }

    @Override
    public List<T> findByExample(T exampleInstance) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T makePersistent(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void makeTransient(T entity) {
        getSession().delete(entity);
    }
    
    public void flush() {
        getSession().flush();
    }
 
    public void clear() {
        getSession().clear();
    }
    
    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
   }

}
