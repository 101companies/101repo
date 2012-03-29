/**
 * <copyright>
 * </copyright>
 *
 */
package org.ioicompanies.lang.iOI;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ioicompanies.lang.iOI.Employee#getName <em>Name</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.Employee#getSalary <em>Salary</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.Employee#getWorks_on <em>Works on</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ioicompanies.lang.iOI.IOIPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.ioicompanies.lang.iOI.IOIPackage#getEmployee_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.ioicompanies.lang.iOI.Employee#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Salary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Salary</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Salary</em>' attribute.
   * @see #setSalary(int)
   * @see org.ioicompanies.lang.iOI.IOIPackage#getEmployee_Salary()
   * @model
   * @generated
   */
  int getSalary();

  /**
   * Sets the value of the '{@link org.ioicompanies.lang.iOI.Employee#getSalary <em>Salary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Salary</em>' attribute.
   * @see #getSalary()
   * @generated
   */
  void setSalary(int value);

  /**
   * Returns the value of the '<em><b>Works on</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Works on</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Works on</em>' reference.
   * @see #setWorks_on(Position)
   * @see org.ioicompanies.lang.iOI.IOIPackage#getEmployee_Works_on()
   * @model
   * @generated
   */
  Position getWorks_on();

  /**
   * Sets the value of the '{@link org.ioicompanies.lang.iOI.Employee#getWorks_on <em>Works on</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Works on</em>' reference.
   * @see #getWorks_on()
   * @generated
   */
  void setWorks_on(Position value);

} // Employee
