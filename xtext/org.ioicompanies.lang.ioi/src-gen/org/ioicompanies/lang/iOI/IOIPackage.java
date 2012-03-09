/**
 * <copyright>
 * </copyright>
 *
 */
package org.ioicompanies.lang.iOI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.ioicompanies.lang.iOI.IOIFactory
 * @model kind="package"
 * @generated
 */
public interface IOIPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "iOI";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.ioicompanies.org/lang/IOI";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "iOI";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IOIPackage eINSTANCE = org.ioicompanies.lang.iOI.impl.IOIPackageImpl.init();

  /**
   * The meta object id for the '{@link org.ioicompanies.lang.iOI.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.ioicompanies.lang.iOI.impl.ModelImpl
   * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Companies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__COMPANIES = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.ioicompanies.lang.iOI.impl.EmployeeImpl <em>Employee</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.ioicompanies.lang.iOI.impl.EmployeeImpl
   * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getEmployee()
   * @generated
   */
  int EMPLOYEE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPLOYEE__NAME = 0;

  /**
   * The feature id for the '<em><b>Salary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPLOYEE__SALARY = 1;

  /**
   * The feature id for the '<em><b>Works on</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPLOYEE__WORKS_ON = 2;

  /**
   * The number of structural features of the '<em>Employee</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPLOYEE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.ioicompanies.lang.iOI.impl.CompanyImpl <em>Company</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.ioicompanies.lang.iOI.impl.CompanyImpl
   * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getCompany()
   * @generated
   */
  int COMPANY = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPANY__NAME = 0;

  /**
   * The feature id for the '<em><b>Positions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPANY__POSITIONS = 1;

  /**
   * The feature id for the '<em><b>Departments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPANY__DEPARTMENTS = 2;

  /**
   * The number of structural features of the '<em>Company</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPANY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.ioicompanies.lang.iOI.impl.DepartmentImpl <em>Department</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.ioicompanies.lang.iOI.impl.DepartmentImpl
   * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getDepartment()
   * @generated
   */
  int DEPARTMENT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPARTMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Manager</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPARTMENT__MANAGER = 1;

  /**
   * The feature id for the '<em><b>Employees</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPARTMENT__EMPLOYEES = 2;

  /**
   * The feature id for the '<em><b>Sub department</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPARTMENT__SUB_DEPARTMENT = 3;

  /**
   * The number of structural features of the '<em>Department</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPARTMENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.ioicompanies.lang.iOI.impl.PositionImpl <em>Position</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.ioicompanies.lang.iOI.impl.PositionImpl
   * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getPosition()
   * @generated
   */
  int POSITION = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITION__NAME = 0;

  /**
   * The number of structural features of the '<em>Position</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.ioicompanies.lang.iOI.impl.ManagerImpl <em>Manager</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.ioicompanies.lang.iOI.impl.ManagerImpl
   * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getManager()
   * @generated
   */
  int MANAGER = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANAGER__NAME = EMPLOYEE__NAME;

  /**
   * The feature id for the '<em><b>Salary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANAGER__SALARY = EMPLOYEE__SALARY;

  /**
   * The feature id for the '<em><b>Works on</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANAGER__WORKS_ON = EMPLOYEE__WORKS_ON;

  /**
   * The number of structural features of the '<em>Manager</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MANAGER_FEATURE_COUNT = EMPLOYEE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.ioicompanies.lang.iOI.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.ioicompanies.lang.iOI.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.ioicompanies.lang.iOI.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.ioicompanies.lang.iOI.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.ioicompanies.lang.iOI.Model#getCompanies <em>Companies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Companies</em>'.
   * @see org.ioicompanies.lang.iOI.Model#getCompanies()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Companies();

  /**
   * Returns the meta object for class '{@link org.ioicompanies.lang.iOI.Employee <em>Employee</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Employee</em>'.
   * @see org.ioicompanies.lang.iOI.Employee
   * @generated
   */
  EClass getEmployee();

  /**
   * Returns the meta object for the attribute '{@link org.ioicompanies.lang.iOI.Employee#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.ioicompanies.lang.iOI.Employee#getName()
   * @see #getEmployee()
   * @generated
   */
  EAttribute getEmployee_Name();

  /**
   * Returns the meta object for the attribute '{@link org.ioicompanies.lang.iOI.Employee#getSalary <em>Salary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Salary</em>'.
   * @see org.ioicompanies.lang.iOI.Employee#getSalary()
   * @see #getEmployee()
   * @generated
   */
  EAttribute getEmployee_Salary();

  /**
   * Returns the meta object for the reference '{@link org.ioicompanies.lang.iOI.Employee#getWorks_on <em>Works on</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Works on</em>'.
   * @see org.ioicompanies.lang.iOI.Employee#getWorks_on()
   * @see #getEmployee()
   * @generated
   */
  EReference getEmployee_Works_on();

  /**
   * Returns the meta object for class '{@link org.ioicompanies.lang.iOI.Company <em>Company</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Company</em>'.
   * @see org.ioicompanies.lang.iOI.Company
   * @generated
   */
  EClass getCompany();

  /**
   * Returns the meta object for the attribute '{@link org.ioicompanies.lang.iOI.Company#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.ioicompanies.lang.iOI.Company#getName()
   * @see #getCompany()
   * @generated
   */
  EAttribute getCompany_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.ioicompanies.lang.iOI.Company#getPositions <em>Positions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Positions</em>'.
   * @see org.ioicompanies.lang.iOI.Company#getPositions()
   * @see #getCompany()
   * @generated
   */
  EReference getCompany_Positions();

  /**
   * Returns the meta object for the containment reference list '{@link org.ioicompanies.lang.iOI.Company#getDepartments <em>Departments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Departments</em>'.
   * @see org.ioicompanies.lang.iOI.Company#getDepartments()
   * @see #getCompany()
   * @generated
   */
  EReference getCompany_Departments();

  /**
   * Returns the meta object for class '{@link org.ioicompanies.lang.iOI.Department <em>Department</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Department</em>'.
   * @see org.ioicompanies.lang.iOI.Department
   * @generated
   */
  EClass getDepartment();

  /**
   * Returns the meta object for the attribute '{@link org.ioicompanies.lang.iOI.Department#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.ioicompanies.lang.iOI.Department#getName()
   * @see #getDepartment()
   * @generated
   */
  EAttribute getDepartment_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.ioicompanies.lang.iOI.Department#getManager <em>Manager</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Manager</em>'.
   * @see org.ioicompanies.lang.iOI.Department#getManager()
   * @see #getDepartment()
   * @generated
   */
  EReference getDepartment_Manager();

  /**
   * Returns the meta object for the containment reference list '{@link org.ioicompanies.lang.iOI.Department#getEmployees <em>Employees</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Employees</em>'.
   * @see org.ioicompanies.lang.iOI.Department#getEmployees()
   * @see #getDepartment()
   * @generated
   */
  EReference getDepartment_Employees();

  /**
   * Returns the meta object for the containment reference '{@link org.ioicompanies.lang.iOI.Department#getSub_department <em>Sub department</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub department</em>'.
   * @see org.ioicompanies.lang.iOI.Department#getSub_department()
   * @see #getDepartment()
   * @generated
   */
  EReference getDepartment_Sub_department();

  /**
   * Returns the meta object for class '{@link org.ioicompanies.lang.iOI.Position <em>Position</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Position</em>'.
   * @see org.ioicompanies.lang.iOI.Position
   * @generated
   */
  EClass getPosition();

  /**
   * Returns the meta object for the attribute '{@link org.ioicompanies.lang.iOI.Position#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.ioicompanies.lang.iOI.Position#getName()
   * @see #getPosition()
   * @generated
   */
  EAttribute getPosition_Name();

  /**
   * Returns the meta object for class '{@link org.ioicompanies.lang.iOI.Manager <em>Manager</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Manager</em>'.
   * @see org.ioicompanies.lang.iOI.Manager
   * @generated
   */
  EClass getManager();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  IOIFactory getIOIFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.ioicompanies.lang.iOI.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.ioicompanies.lang.iOI.impl.ModelImpl
     * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Companies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__COMPANIES = eINSTANCE.getModel_Companies();

    /**
     * The meta object literal for the '{@link org.ioicompanies.lang.iOI.impl.EmployeeImpl <em>Employee</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.ioicompanies.lang.iOI.impl.EmployeeImpl
     * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getEmployee()
     * @generated
     */
    EClass EMPLOYEE = eINSTANCE.getEmployee();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EMPLOYEE__NAME = eINSTANCE.getEmployee_Name();

    /**
     * The meta object literal for the '<em><b>Salary</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EMPLOYEE__SALARY = eINSTANCE.getEmployee_Salary();

    /**
     * The meta object literal for the '<em><b>Works on</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EMPLOYEE__WORKS_ON = eINSTANCE.getEmployee_Works_on();

    /**
     * The meta object literal for the '{@link org.ioicompanies.lang.iOI.impl.CompanyImpl <em>Company</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.ioicompanies.lang.iOI.impl.CompanyImpl
     * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getCompany()
     * @generated
     */
    EClass COMPANY = eINSTANCE.getCompany();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPANY__NAME = eINSTANCE.getCompany_Name();

    /**
     * The meta object literal for the '<em><b>Positions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPANY__POSITIONS = eINSTANCE.getCompany_Positions();

    /**
     * The meta object literal for the '<em><b>Departments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPANY__DEPARTMENTS = eINSTANCE.getCompany_Departments();

    /**
     * The meta object literal for the '{@link org.ioicompanies.lang.iOI.impl.DepartmentImpl <em>Department</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.ioicompanies.lang.iOI.impl.DepartmentImpl
     * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getDepartment()
     * @generated
     */
    EClass DEPARTMENT = eINSTANCE.getDepartment();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEPARTMENT__NAME = eINSTANCE.getDepartment_Name();

    /**
     * The meta object literal for the '<em><b>Manager</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPARTMENT__MANAGER = eINSTANCE.getDepartment_Manager();

    /**
     * The meta object literal for the '<em><b>Employees</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPARTMENT__EMPLOYEES = eINSTANCE.getDepartment_Employees();

    /**
     * The meta object literal for the '<em><b>Sub department</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPARTMENT__SUB_DEPARTMENT = eINSTANCE.getDepartment_Sub_department();

    /**
     * The meta object literal for the '{@link org.ioicompanies.lang.iOI.impl.PositionImpl <em>Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.ioicompanies.lang.iOI.impl.PositionImpl
     * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getPosition()
     * @generated
     */
    EClass POSITION = eINSTANCE.getPosition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POSITION__NAME = eINSTANCE.getPosition_Name();

    /**
     * The meta object literal for the '{@link org.ioicompanies.lang.iOI.impl.ManagerImpl <em>Manager</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.ioicompanies.lang.iOI.impl.ManagerImpl
     * @see org.ioicompanies.lang.iOI.impl.IOIPackageImpl#getManager()
     * @generated
     */
    EClass MANAGER = eINSTANCE.getManager();

  }

} //IOIPackage
