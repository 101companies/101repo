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
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Company#getDepts <em>Depts</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getCompany()
 * @model
 * @generated
 */
public interface Company extends EObject {
	/**
	 * Returns the value of the '<em><b>Depts</b></em>' containment reference list.
	 * The list contents are of type {@link company.Dept}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depts</em>' containment reference list.
	 * @see company.CompanyPackage#getCompany_Depts()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Dept> getDepts();

} // Company
