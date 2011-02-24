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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subunit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link company.impl.SubunitImpl#getPu <em>Pu</em>}</li>
 *   <li>{@link company.impl.SubunitImpl#getDu <em>Du</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubunitImpl extends EObjectImpl implements Subunit {
	/**
	 * The cached value of the '{@link #getPu() <em>Pu</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPu()
	 * @generated
	 * @ordered
	 */
	protected Employee pu;

	/**
	 * The cached value of the '{@link #getDu() <em>Du</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDu()
	 * @generated
	 * @ordered
	 */
	protected Dept du;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubunitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompanyPackage.Literals.SUBUNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getPu() {
		return pu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPu(Employee newPu, NotificationChain msgs) {
		Employee oldPu = pu;
		pu = newPu;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.SUBUNIT__PU, oldPu, newPu);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPu(Employee newPu) {
		if (newPu != pu) {
			NotificationChain msgs = null;
			if (pu != null)
				msgs = ((InternalEObject)pu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.SUBUNIT__PU, null, msgs);
			if (newPu != null)
				msgs = ((InternalEObject)newPu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.SUBUNIT__PU, null, msgs);
			msgs = basicSetPu(newPu, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.SUBUNIT__PU, newPu, newPu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dept getDu() {
		return du;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDu(Dept newDu, NotificationChain msgs) {
		Dept oldDu = du;
		du = newDu;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.SUBUNIT__DU, oldDu, newDu);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDu(Dept newDu) {
		if (newDu != du) {
			NotificationChain msgs = null;
			if (du != null)
				msgs = ((InternalEObject)du).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.SUBUNIT__DU, null, msgs);
			if (newDu != null)
				msgs = ((InternalEObject)newDu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.SUBUNIT__DU, null, msgs);
			msgs = basicSetDu(newDu, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.SUBUNIT__DU, newDu, newDu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompanyPackage.SUBUNIT__PU:
				return basicSetPu(null, msgs);
			case CompanyPackage.SUBUNIT__DU:
				return basicSetDu(null, msgs);
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
			case CompanyPackage.SUBUNIT__PU:
				return getPu();
			case CompanyPackage.SUBUNIT__DU:
				return getDu();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompanyPackage.SUBUNIT__PU:
				setPu((Employee)newValue);
				return;
			case CompanyPackage.SUBUNIT__DU:
				setDu((Dept)newValue);
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
			case CompanyPackage.SUBUNIT__PU:
				setPu((Employee)null);
				return;
			case CompanyPackage.SUBUNIT__DU:
				setDu((Dept)null);
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
			case CompanyPackage.SUBUNIT__PU:
				return pu != null;
			case CompanyPackage.SUBUNIT__DU:
				return du != null;
		}
		return super.eIsSet(featureID);
	}

} //SubunitImpl
