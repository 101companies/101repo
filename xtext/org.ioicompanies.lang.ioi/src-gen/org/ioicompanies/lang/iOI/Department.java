/**
 * <copyright>
 * </copyright>
 *
 */
package org.ioicompanies.lang.iOI;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ioicompanies.lang.iOI.Department#getName <em>Name</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.Department#getManager <em>Manager</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.Department#getEmployees <em>Employees</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.Department#getSub_department <em>Sub department</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ioicompanies.lang.iOI.IOIPackage#getDepartment()
 * @model
 * @generated
 */
public interface Department extends EObject
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
   * @see org.ioicompanies.lang.iOI.IOIPackage#getDepartment_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.ioicompanies.lang.iOI.Department#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Manager</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Manager</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Manager</em>' containment reference.
   * @see #setManager(Manager)
   * @see org.ioicompanies.lang.iOI.IOIPackage#getDepartment_Manager()
   * @model containment="true"
   * @generated
   */
  Manager getManager();

  /**
   * Sets the value of the '{@link org.ioicompanies.lang.iOI.Department#getManager <em>Manager</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Manager</em>' containment reference.
   * @see #getManager()
   * @generated
   */
  void setManager(Manager value);

  /**
   * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
   * The list contents are of type {@link org.ioicompanies.lang.iOI.Employee}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Employees</em>' containment reference list.
   * @see org.ioicompanies.lang.iOI.IOIPackage#getDepartment_Employees()
   * @model containment="true"
   * @generated
   */
  EList<Employee> getEmployees();

  /**
   * Returns the value of the '<em><b>Sub department</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub department</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub department</em>' containment reference.
   * @see #setSub_department(Department)
   * @see org.ioicompanies.lang.iOI.IOIPackage#getDepartment_Sub_department()
   * @model containment="true"
   * @generated
   */
  Department getSub_department();

  /**
   * Sets the value of the '{@link org.ioicompanies.lang.iOI.Department#getSub_department <em>Sub department</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub department</em>' containment reference.
   * @see #getSub_department()
   * @generated
   */
  void setSub_department(Department value);

} // Department
