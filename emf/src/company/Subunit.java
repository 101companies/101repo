/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subunit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Subunit#getPu <em>Pu</em>}</li>
 *   <li>{@link company.Subunit#getDu <em>Du</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getSubunit()
 * @model
 * @generated
 */
public interface Subunit extends EObject {
	/**
	 * Returns the value of the '<em><b>Pu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pu</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pu</em>' containment reference.
	 * @see #setPu(Employee)
	 * @see company.CompanyPackage#getSubunit_Pu()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Employee getPu();

	/**
	 * Sets the value of the '{@link company.Subunit#getPu <em>Pu</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pu</em>' containment reference.
	 * @see #getPu()
	 * @generated
	 */
	void setPu(Employee value);

	/**
	 * Returns the value of the '<em><b>Du</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Du</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Du</em>' containment reference.
	 * @see #setDu(Dept)
	 * @see company.CompanyPackage#getSubunit_Du()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Dept getDu();

	/**
	 * Sets the value of the '{@link company.Subunit#getDu <em>Du</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Du</em>' containment reference.
	 * @see #getDu()
	 * @generated
	 */
	void setDu(Dept value);

} // Subunit
