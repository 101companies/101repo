/**
 * <copyright>
 * </copyright>
 *
 */
package org.ioicompanies.lang.iOI.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.ioicompanies.lang.iOI.Employee;
import org.ioicompanies.lang.iOI.IOIPackage;
import org.ioicompanies.lang.iOI.Position;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.ioicompanies.lang.iOI.impl.EmployeeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.impl.EmployeeImpl#getSalary <em>Salary</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.impl.EmployeeImpl#getWorks_on <em>Works on</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmployeeImpl extends MinimalEObjectImpl.Container implements Employee
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
   * The default value of the '{@link #getSalary() <em>Salary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSalary()
   * @generated
   * @ordered
   */
  protected static final int SALARY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSalary() <em>Salary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSalary()
   * @generated
   * @ordered
   */
  protected int salary = SALARY_EDEFAULT;

  /**
   * The cached value of the '{@link #getWorks_on() <em>Works on</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorks_on()
   * @generated
   * @ordered
   */
  protected Position works_on;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EmployeeImpl()
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
    return IOIPackage.Literals.EMPLOYEE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, IOIPackage.EMPLOYEE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSalary()
  {
    return salary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSalary(int newSalary)
  {
    int oldSalary = salary;
    salary = newSalary;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IOIPackage.EMPLOYEE__SALARY, oldSalary, salary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Position getWorks_on()
  {
    if (works_on != null && works_on.eIsProxy())
    {
      InternalEObject oldWorks_on = (InternalEObject)works_on;
      works_on = (Position)eResolveProxy(oldWorks_on);
      if (works_on != oldWorks_on)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, IOIPackage.EMPLOYEE__WORKS_ON, oldWorks_on, works_on));
      }
    }
    return works_on;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Position basicGetWorks_on()
  {
    return works_on;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorks_on(Position newWorks_on)
  {
    Position oldWorks_on = works_on;
    works_on = newWorks_on;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IOIPackage.EMPLOYEE__WORKS_ON, oldWorks_on, works_on));
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
      case IOIPackage.EMPLOYEE__NAME:
        return getName();
      case IOIPackage.EMPLOYEE__SALARY:
        return getSalary();
      case IOIPackage.EMPLOYEE__WORKS_ON:
        if (resolve) return getWorks_on();
        return basicGetWorks_on();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case IOIPackage.EMPLOYEE__NAME:
        setName((String)newValue);
        return;
      case IOIPackage.EMPLOYEE__SALARY:
        setSalary((Integer)newValue);
        return;
      case IOIPackage.EMPLOYEE__WORKS_ON:
        setWorks_on((Position)newValue);
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
      case IOIPackage.EMPLOYEE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IOIPackage.EMPLOYEE__SALARY:
        setSalary(SALARY_EDEFAULT);
        return;
      case IOIPackage.EMPLOYEE__WORKS_ON:
        setWorks_on((Position)null);
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
      case IOIPackage.EMPLOYEE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IOIPackage.EMPLOYEE__SALARY:
        return salary != SALARY_EDEFAULT;
      case IOIPackage.EMPLOYEE__WORKS_ON:
        return works_on != null;
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
    result.append(", salary: ");
    result.append(salary);
    result.append(')');
    return result.toString();
  }

} //EmployeeImpl
