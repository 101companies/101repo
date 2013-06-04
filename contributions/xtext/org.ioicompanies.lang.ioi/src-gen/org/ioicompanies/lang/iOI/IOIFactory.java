/**
 */
package org.ioicompanies.lang.iOI;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.ioicompanies.lang.iOI.IOIPackage
 * @generated
 */
public interface IOIFactory extends EFactory
{
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  IOIFactory eINSTANCE = org.ioicompanies.lang.iOI.impl.IOIFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
  Model createModel();

  /**
	 * Returns a new object of class '<em>Employee</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Employee</em>'.
	 * @generated
	 */
  Employee createEmployee();

  /**
	 * Returns a new object of class '<em>Company</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Company</em>'.
	 * @generated
	 */
  Company createCompany();

  /**
	 * Returns a new object of class '<em>Department</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Department</em>'.
	 * @generated
	 */
  Department createDepartment();

  /**
	 * Returns a new object of class '<em>Position</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Position</em>'.
	 * @generated
	 */
  Position createPosition();

  /**
	 * Returns a new object of class '<em>Manager</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manager</em>'.
	 * @generated
	 */
  Manager createManager();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  IOIPackage getIOIPackage();

} //IOIFactory
