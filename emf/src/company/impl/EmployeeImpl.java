/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company.impl;

import company.CompanyPackage;
import company.Employee;
import company.Person;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link company.impl.EmployeeImpl#getPerson <em>Person</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getSalary <em>Salary</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getMentor <em>Mentor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmployeeImpl extends EObjectImpl implements Employee {
	/**
	 * The cached value of the '{@link #getPerson() <em>Person</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerson()
	 * @generated
	 * @ordered
	 */
	protected Person person;

	/**
	 * The default value of the '{@link #getSalary() <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalary()
	 * @generated
	 * @ordered
	 */
	protected static final double SALARY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSalary() <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalary()
	 * @generated
	 * @ordered
	 */
	protected double salary = SALARY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMentor() <em>Mentor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMentor()
	 * @generated
	 * @ordered
	 */
	protected Employee mentor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmployeeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompanyPackage.Literals.EMPLOYEE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPerson(Person newPerson, NotificationChain msgs) {
		Person oldPerson = person;
		person = newPerson;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__PERSON, oldPerson, newPerson);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerson(Person newPerson) {
		if (newPerson != person) {
			NotificationChain msgs = null;
			if (person != null)
				msgs = ((InternalEObject)person).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__PERSON, null, msgs);
			if (newPerson != null)
				msgs = ((InternalEObject)newPerson).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__PERSON, null, msgs);
			msgs = basicSetPerson(newPerson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__PERSON, newPerson, newPerson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalary(double newSalary) {
		double oldSalary = salary;
		salary = newSalary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__SALARY, oldSalary, salary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getMentor() {
		if (mentor != null && mentor.eIsProxy()) {
			InternalEObject oldMentor = (InternalEObject)mentor;
			mentor = (Employee)eResolveProxy(oldMentor);
			if (mentor != oldMentor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompanyPackage.EMPLOYEE__MENTOR, oldMentor, mentor));
			}
		}
		return mentor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetMentor() {
		return mentor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMentor(Employee newMentor) {
		Employee oldMentor = mentor;
		mentor = newMentor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__MENTOR, oldMentor, mentor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompanyPackage.EMPLOYEE__PERSON:
				return basicSetPerson(null, msgs);
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
			case CompanyPackage.EMPLOYEE__PERSON:
				return getPerson();
			case CompanyPackage.EMPLOYEE__SALARY:
				return getSalary();
			case CompanyPackage.EMPLOYEE__MENTOR:
				if (resolve) return getMentor();
				return basicGetMentor();
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
			case CompanyPackage.EMPLOYEE__PERSON:
				setPerson((Person)newValue);
				return;
			case CompanyPackage.EMPLOYEE__SALARY:
				setSalary((Double)newValue);
				return;
			case CompanyPackage.EMPLOYEE__MENTOR:
				setMentor((Employee)newValue);
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
			case CompanyPackage.EMPLOYEE__PERSON:
				setPerson((Person)null);
				return;
			case CompanyPackage.EMPLOYEE__SALARY:
				setSalary(SALARY_EDEFAULT);
				return;
			case CompanyPackage.EMPLOYEE__MENTOR:
				setMentor((Employee)null);
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
			case CompanyPackage.EMPLOYEE__PERSON:
				return person != null;
			case CompanyPackage.EMPLOYEE__SALARY:
				return salary != SALARY_EDEFAULT;
			case CompanyPackage.EMPLOYEE__MENTOR:
				return mentor != null;
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
		result.append(" (salary: ");
		result.append(salary);
		result.append(')');
		return result.toString();
	}

} //EmployeeImpl
