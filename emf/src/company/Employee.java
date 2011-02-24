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
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Employee#getPerson <em>Person</em>}</li>
 *   <li>{@link company.Employee#getSalary <em>Salary</em>}</li>
 *   <li>{@link company.Employee#getMentor <em>Mentor</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends EObject {
	/**
	 * Returns the value of the '<em><b>Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' containment reference.
	 * @see #setPerson(Person)
	 * @see company.CompanyPackage#getEmployee_Person()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Person getPerson();

	/**
	 * Sets the value of the '{@link company.Employee#getPerson <em>Person</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' containment reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(Person value);

	/**
	 * Returns the value of the '<em><b>Salary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salary</em>' attribute.
	 * @see #setSalary(double)
	 * @see company.CompanyPackage#getEmployee_Salary()
	 * @model
	 * @generated
	 */
	double getSalary();

	/**
	 * Sets the value of the '{@link company.Employee#getSalary <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Salary</em>' attribute.
	 * @see #getSalary()
	 * @generated
	 */
	void setSalary(double value);

	/**
	 * Returns the value of the '<em><b>Mentor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mentor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mentor</em>' reference.
	 * @see #setMentor(Employee)
	 * @see company.CompanyPackage#getEmployee_Mentor()
	 * @model
	 * @generated
	 */
	Employee getMentor();

	/**
	 * Sets the value of the '{@link company.Employee#getMentor <em>Mentor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mentor</em>' reference.
	 * @see #getMentor()
	 * @generated
	 */
	void setMentor(Employee value);

} // Employee
