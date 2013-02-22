/**
 */
package org.ioicompanies.lang.iOI;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ioicompanies.lang.iOI.Model#getName <em>Name</em>}</li>
 *   <li>{@link org.ioicompanies.lang.iOI.Model#getCompanies <em>Companies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ioicompanies.lang.iOI.IOIPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
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
	 * @see org.ioicompanies.lang.iOI.IOIPackage#getModel_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.ioicompanies.lang.iOI.Model#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Companies</b></em>' containment reference list.
	 * The list contents are of type {@link org.ioicompanies.lang.iOI.Company}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Companies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Companies</em>' containment reference list.
	 * @see org.ioicompanies.lang.iOI.IOIPackage#getModel_Companies()
	 * @model containment="true"
	 * @generated
	 */
  EList<Company> getCompanies();

} // Model
