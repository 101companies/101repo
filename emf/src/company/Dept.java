/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dept</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Dept#getName <em>Name</em>}</li>
 *   <li>{@link company.Dept#getManager <em>Manager</em>}</li>
 *   <li>{@link company.Dept#getSubunits <em>Subunits</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getDept()
 * @model
 * @generated
 */
public interface Dept extends EObject {
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
	 * @see company.CompanyPackage#getDept_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link company.Dept#getName <em>Name</em>}' attribute.
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
	 * @see #setManager(Employee)
	 * @see company.CompanyPackage#getDept_Manager()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Employee getManager();

	/**
	 * Sets the value of the '{@link company.Dept#getManager <em>Manager</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager</em>' containment reference.
	 * @see #getManager()
	 * @generated
	 */
	void setManager(Employee value);

	/**
	 * Returns the value of the '<em><b>Subunits</b></em>' containment reference list.
	 * The list contents are of type {@link company.Subunit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subunits</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subunits</em>' containment reference list.
	 * @see company.CompanyPackage#getDept_Subunits()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Subunit> getSubunits();

} // Dept
