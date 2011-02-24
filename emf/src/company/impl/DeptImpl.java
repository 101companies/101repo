/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company.impl;

import company.CompanyPackage;
import company.Dept;
import company.Employee;
import company.Subunit;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dept</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link company.impl.DeptImpl#getName <em>Name</em>}</li>
 *   <li>{@link company.impl.DeptImpl#getManager <em>Manager</em>}</li>
 *   <li>{@link company.impl.DeptImpl#getSubunits <em>Subunits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeptImpl extends EObjectImpl implements Dept {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getManager() <em>Manager</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManager()
	 * @generated
	 * @ordered
	 */
	protected Employee manager;

	/**
	 * The cached value of the '{@link #getSubunits() <em>Subunits</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubunits()
	 * @generated
	 * @ordered
	 */
	protected EList<Subunit> subunits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompanyPackage.Literals.DEPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getManager() {
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetManager(Employee newManager, NotificationChain msgs) {
		Employee oldManager = manager;
		manager = newManager;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPT__MANAGER, oldManager, newManager);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManager(Employee newManager) {
		if (newManager != manager) {
			NotificationChain msgs = null;
			if (manager != null)
				msgs = ((InternalEObject)manager).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.DEPT__MANAGER, null, msgs);
			if (newManager != null)
				msgs = ((InternalEObject)newManager).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.DEPT__MANAGER, null, msgs);
			msgs = basicSetManager(newManager, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPT__MANAGER, newManager, newManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subunit> getSubunits() {
		if (subunits == null) {
			subunits = new EObjectContainmentEList<Subunit>(Subunit.class, this, CompanyPackage.DEPT__SUBUNITS);
		}
		return subunits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompanyPackage.DEPT__MANAGER:
				return basicSetManager(null, msgs);
			case CompanyPackage.DEPT__SUBUNITS:
				return ((InternalEList<?>)getSubunits()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompanyPackage.DEPT__NAME:
				return getName();
			case CompanyPackage.DEPT__MANAGER:
				return getManager();
			case CompanyPackage.DEPT__SUBUNITS:
				return getSubunits();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompanyPackage.DEPT__NAME:
				setName((String)newValue);
				return;
			case CompanyPackage.DEPT__MANAGER:
				setManager((Employee)newValue);
				return;
			case CompanyPackage.DEPT__SUBUNITS:
				getSubunits().clear();
				getSubunits().addAll((Collection<? extends Subunit>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CompanyPackage.DEPT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompanyPackage.DEPT__MANAGER:
				setManager((Employee)null);
				return;
			case CompanyPackage.DEPT__SUBUNITS:
				getSubunits().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CompanyPackage.DEPT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompanyPackage.DEPT__MANAGER:
				return manager != null;
			case CompanyPackage.DEPT__SUBUNITS:
				return subunits != null && !subunits.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //DeptImpl
