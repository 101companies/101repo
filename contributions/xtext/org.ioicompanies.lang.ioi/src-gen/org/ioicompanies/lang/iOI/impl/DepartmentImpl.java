/**
 * <copyright>
 * </copyright>
 *
 */
package org.ioicompanies.lang.iOI.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.ioicompanies.lang.iOI.Department;
import org.ioicompanies.lang.iOI.Employee;
import org.ioicompanies.lang.iOI.IOIPackage;
import org.ioicompanies.lang.iOI.Manager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ioicompanies.lang.iOI.impl.DepartmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.impl.DepartmentImpl#getManager <em>Manager</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.impl.DepartmentImpl#getEmployees <em>Employees</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.impl.DepartmentImpl#getSub_department <em>Sub department</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DepartmentImpl extends MinimalEObjectImpl.Container implements Department
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getManager() <em>Manager</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getManager()
   * @generated
   * @ordered
   */
  protected Manager manager;

  /**
   * The cached value of the '{@link #getEmployees() <em>Employees</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmployees()
   * @generated
   * @ordered
   */
  protected EList<Employee> employees;

  /**
   * The cached value of the '{@link #getSub_department() <em>Sub department</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub_department()
   * @generated
   * @ordered
   */
  protected Department sub_department;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DepartmentImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return IOIPackage.Literals.DEPARTMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IOIPackage.DEPARTMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Manager getManager()
  {
    return manager;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetManager(Manager newManager, NotificationChain msgs)
  {
    Manager oldManager = manager;
    manager = newManager;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IOIPackage.DEPARTMENT__MANAGER, oldManager, newManager);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setManager(Manager newManager)
  {
    if (newManager != manager)
    {
      NotificationChain msgs = null;
      if (manager != null)
        msgs = ((InternalEObject)manager).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IOIPackage.DEPARTMENT__MANAGER, null, msgs);
      if (newManager != null)
        msgs = ((InternalEObject)newManager).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IOIPackage.DEPARTMENT__MANAGER, null, msgs);
      msgs = basicSetManager(newManager, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IOIPackage.DEPARTMENT__MANAGER, newManager, newManager));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Employee> getEmployees()
  {
    if (employees == null)
    {
      employees = new EObjectContainmentEList<Employee>(Employee.class, this, IOIPackage.DEPARTMENT__EMPLOYEES);
    }
    return employees;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Department getSub_department()
  {
    return sub_department;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSub_department(Department newSub_department, NotificationChain msgs)
  {
    Department oldSub_department = sub_department;
    sub_department = newSub_department;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IOIPackage.DEPARTMENT__SUB_DEPARTMENT, oldSub_department, newSub_department);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSub_department(Department newSub_department)
  {
    if (newSub_department != sub_department)
    {
      NotificationChain msgs = null;
      if (sub_department != null)
        msgs = ((InternalEObject)sub_department).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IOIPackage.DEPARTMENT__SUB_DEPARTMENT, null, msgs);
      if (newSub_department != null)
        msgs = ((InternalEObject)newSub_department).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IOIPackage.DEPARTMENT__SUB_DEPARTMENT, null, msgs);
      msgs = basicSetSub_department(newSub_department, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IOIPackage.DEPARTMENT__SUB_DEPARTMENT, newSub_department, newSub_department));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case IOIPackage.DEPARTMENT__MANAGER:
        return basicSetManager(null, msgs);
      case IOIPackage.DEPARTMENT__EMPLOYEES:
        return ((InternalEList<?>)getEmployees()).basicRemove(otherEnd, msgs);
      case IOIPackage.DEPARTMENT__SUB_DEPARTMENT:
        return basicSetSub_department(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case IOIPackage.DEPARTMENT__NAME:
        return getName();
      case IOIPackage.DEPARTMENT__MANAGER:
        return getManager();
      case IOIPackage.DEPARTMENT__EMPLOYEES:
        return getEmployees();
      case IOIPackage.DEPARTMENT__SUB_DEPARTMENT:
        return getSub_department();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case IOIPackage.DEPARTMENT__NAME:
        setName((String)newValue);
        return;
      case IOIPackage.DEPARTMENT__MANAGER:
        setManager((Manager)newValue);
        return;
      case IOIPackage.DEPARTMENT__EMPLOYEES:
        getEmployees().clear();
        getEmployees().addAll((Collection<? extends Employee>)newValue);
        return;
      case IOIPackage.DEPARTMENT__SUB_DEPARTMENT:
        setSub_department((Department)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case IOIPackage.DEPARTMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IOIPackage.DEPARTMENT__MANAGER:
        setManager((Manager)null);
        return;
      case IOIPackage.DEPARTMENT__EMPLOYEES:
        getEmployees().clear();
        return;
      case IOIPackage.DEPARTMENT__SUB_DEPARTMENT:
        setSub_department((Department)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case IOIPackage.DEPARTMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IOIPackage.DEPARTMENT__MANAGER:
        return manager != null;
      case IOIPackage.DEPARTMENT__EMPLOYEES:
        return employees != null && !employees.isEmpty();
      case IOIPackage.DEPARTMENT__SUB_DEPARTMENT:
        return sub_department != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //DepartmentImpl
