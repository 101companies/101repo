/**
 */
package org.ioicompanies.lang.iOI.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.ioicompanies.lang.iOI.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IOIFactoryImpl extends EFactoryImpl implements IOIFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static IOIFactory init()
  {
		try {
			IOIFactory theIOIFactory = (IOIFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ioicompanies.org/lang/IOI"); 
			if (theIOIFactory != null) {
				return theIOIFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IOIFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IOIFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
		switch (eClass.getClassifierID()) {
			case IOIPackage.MODEL: return createModel();
			case IOIPackage.EMPLOYEE: return createEmployee();
			case IOIPackage.COMPANY: return createCompany();
			case IOIPackage.DEPARTMENT: return createDepartment();
			case IOIPackage.POSITION: return createPosition();
			case IOIPackage.MANAGER: return createManager();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Model createModel()
  {
		ModelImpl model = new ModelImpl();
		return model;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Employee createEmployee()
  {
		EmployeeImpl employee = new EmployeeImpl();
		return employee;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Company createCompany()
  {
		CompanyImpl company = new CompanyImpl();
		return company;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Department createDepartment()
  {
		DepartmentImpl department = new DepartmentImpl();
		return department;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Position createPosition()
  {
		PositionImpl position = new PositionImpl();
		return position;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Manager createManager()
  {
		ManagerImpl manager = new ManagerImpl();
		return manager;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IOIPackage getIOIPackage()
  {
		return (IOIPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static IOIPackage getPackage()
  {
		return IOIPackage.eINSTANCE;
	}

} //IOIFactoryImpl
