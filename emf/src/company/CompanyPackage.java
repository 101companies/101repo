/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company;

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
 * @see company.CompanyFactory
 * @model kind="package"
 * @generated
 */
public interface CompanyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "company";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.company.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompanyPackage eINSTANCE = company.impl.CompanyPackageImpl.init();

	/**
	 * The meta object id for the '{@link company.impl.CompanyImpl <em>Company</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see company.impl.CompanyImpl
	 * @see company.impl.CompanyPackageImpl#getCompany()
	 * @generated
	 */
	int COMPANY = 0;

	/**
	 * The feature id for the '<em><b>Depts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__DEPTS = 0;

	/**
	 * The number of structural features of the '<em>Company</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link company.impl.DeptImpl <em>Dept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see company.impl.DeptImpl
	 * @see company.impl.CompanyPackageImpl#getDept()
	 * @generated
	 */
	int DEPT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPT__MANAGER = 1;

	/**
	 * The feature id for the '<em><b>Subunits</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPT__SUBUNITS = 2;

	/**
	 * The number of structural features of the '<em>Dept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link company.impl.EmployeeImpl <em>Employee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see company.impl.EmployeeImpl
	 * @see company.impl.CompanyPackageImpl#getEmployee()
	 * @generated
	 */
	int EMPLOYEE = 2;

	/**
	 * The feature id for the '<em><b>Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__PERSON = 0;

	/**
	 * The feature id for the '<em><b>Salary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__SALARY = 1;

	/**
	 * The feature id for the '<em><b>Mentor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__MENTOR = 2;

	/**
	 * The number of structural features of the '<em>Employee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link company.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see company.impl.PersonImpl
	 * @see company.impl.CompanyPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link company.impl.SubunitImpl <em>Subunit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see company.impl.SubunitImpl
	 * @see company.impl.CompanyPackageImpl#getSubunit()
	 * @generated
	 */
	int SUBUNIT = 4;

	/**
	 * The feature id for the '<em><b>Pu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBUNIT__PU = 0;

	/**
	 * The feature id for the '<em><b>Du</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBUNIT__DU = 1;

	/**
	 * The number of structural features of the '<em>Subunit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBUNIT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link company.Company <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Company</em>'.
	 * @see company.Company
	 * @generated
	 */
	EClass getCompany();

	/**
	 * Returns the meta object for the containment reference list '{@link company.Company#getDepts <em>Depts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Depts</em>'.
	 * @see company.Company#getDepts()
	 * @see #getCompany()
	 * @generated
	 */
	EReference getCompany_Depts();

	/**
	 * Returns the meta object for class '{@link company.Dept <em>Dept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dept</em>'.
	 * @see company.Dept
	 * @generated
	 */
	EClass getDept();

	/**
	 * Returns the meta object for the attribute '{@link company.Dept#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see company.Dept#getName()
	 * @see #getDept()
	 * @generated
	 */
	EAttribute getDept_Name();

	/**
	 * Returns the meta object for the containment reference '{@link company.Dept#getManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Manager</em>'.
	 * @see company.Dept#getManager()
	 * @see #getDept()
	 * @generated
	 */
	EReference getDept_Manager();

	/**
	 * Returns the meta object for the containment reference list '{@link company.Dept#getSubunits <em>Subunits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subunits</em>'.
	 * @see company.Dept#getSubunits()
	 * @see #getDept()
	 * @generated
	 */
	EReference getDept_Subunits();

	/**
	 * Returns the meta object for class '{@link company.Employee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Employee</em>'.
	 * @see company.Employee
	 * @generated
	 */
	EClass getEmployee();

	/**
	 * Returns the meta object for the containment reference '{@link company.Employee#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Person</em>'.
	 * @see company.Employee#getPerson()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Person();

	/**
	 * Returns the meta object for the attribute '{@link company.Employee#getSalary <em>Salary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Salary</em>'.
	 * @see company.Employee#getSalary()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Salary();

	/**
	 * Returns the meta object for the reference '{@link company.Employee#getMentor <em>Mentor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mentor</em>'.
	 * @see company.Employee#getMentor()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Mentor();

	/**
	 * Returns the meta object for class '{@link company.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see company.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link company.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see company.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for the attribute '{@link company.Person#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see company.Person#getAddress()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Address();

	/**
	 * Returns the meta object for class '{@link company.Subunit <em>Subunit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subunit</em>'.
	 * @see company.Subunit
	 * @generated
	 */
	EClass getSubunit();

	/**
	 * Returns the meta object for the containment reference '{@link company.Subunit#getPu <em>Pu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pu</em>'.
	 * @see company.Subunit#getPu()
	 * @see #getSubunit()
	 * @generated
	 */
	EReference getSubunit_Pu();

	/**
	 * Returns the meta object for the containment reference '{@link company.Subunit#getDu <em>Du</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Du</em>'.
	 * @see company.Subunit#getDu()
	 * @see #getSubunit()
	 * @generated
	 */
	EReference getSubunit_Du();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompanyFactory getCompanyFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link company.impl.CompanyImpl <em>Company</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see company.impl.CompanyImpl
		 * @see company.impl.CompanyPackageImpl#getCompany()
		 * @generated
		 */
		EClass COMPANY = eINSTANCE.getCompany();

		/**
		 * The meta object literal for the '<em><b>Depts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPANY__DEPTS = eINSTANCE.getCompany_Depts();

		/**
		 * The meta object literal for the '{@link company.impl.DeptImpl <em>Dept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see company.impl.DeptImpl
		 * @see company.impl.CompanyPackageImpl#getDept()
		 * @generated
		 */
		EClass DEPT = eINSTANCE.getDept();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPT__NAME = eINSTANCE.getDept_Name();

		/**
		 * The meta object literal for the '<em><b>Manager</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPT__MANAGER = eINSTANCE.getDept_Manager();

		/**
		 * The meta object literal for the '<em><b>Subunits</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPT__SUBUNITS = eINSTANCE.getDept_Subunits();

		/**
		 * The meta object literal for the '{@link company.impl.EmployeeImpl <em>Employee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see company.impl.EmployeeImpl
		 * @see company.impl.CompanyPackageImpl#getEmployee()
		 * @generated
		 */
		EClass EMPLOYEE = eINSTANCE.getEmployee();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__PERSON = eINSTANCE.getEmployee_Person();

		/**
		 * The meta object literal for the '<em><b>Salary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__SALARY = eINSTANCE.getEmployee_Salary();

		/**
		 * The meta object literal for the '<em><b>Mentor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__MENTOR = eINSTANCE.getEmployee_Mentor();

		/**
		 * The meta object literal for the '{@link company.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see company.impl.PersonImpl
		 * @see company.impl.CompanyPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__ADDRESS = eINSTANCE.getPerson_Address();

		/**
		 * The meta object literal for the '{@link company.impl.SubunitImpl <em>Subunit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see company.impl.SubunitImpl
		 * @see company.impl.CompanyPackageImpl#getSubunit()
		 * @generated
		 */
		EClass SUBUNIT = eINSTANCE.getSubunit();

		/**
		 * The meta object literal for the '<em><b>Pu</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBUNIT__PU = eINSTANCE.getSubunit_Pu();

		/**
		 * The meta object literal for the '<em><b>Du</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBUNIT__DU = eINSTANCE.getSubunit_Du();

	}

} //CompanyPackage
