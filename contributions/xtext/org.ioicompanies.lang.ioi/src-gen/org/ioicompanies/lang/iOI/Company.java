/**
 */
package org.ioicompanies.lang.iOI;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ioicompanies.lang.iOI.Company#getName <em>Name</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.Company#getPositions <em>Positions</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.Company#getDepartments <em>Departments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ioicompanies.lang.iOI.IOIPackage#getCompany()
 * @model
 * @generated
 */
public interface Company extends EObject
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
	 * @see org.ioicompanies.lang.iOI.IOIPackage#getCompany_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.ioicompanies.lang.iOI.Company#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Positions</b></em>' containment reference list.
	 * The list contents are of type {@link org.ioicompanies.lang.iOI.Position}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Positions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Positions</em>' containment reference list.
	 * @see org.ioicompanies.lang.iOI.IOIPackage#getCompany_Positions()
	 * @model containment="true"
	 * @generated
	 */
  EList<Position> getPositions();

  /**
	 * Returns the value of the '<em><b>Departments</b></em>' containment reference list.
	 * The list contents are of type {@link org.ioicompanies.lang.iOI.Department}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Departments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Departments</em>' containment reference list.
	 * @see org.ioicompanies.lang.iOI.IOIPackage#getCompany_Departments()
	 * @model containment="true"
	 * @generated
	 */
  EList<Department> getDepartments();

} // Company
