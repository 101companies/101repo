package org.softlang.company;

/**
 * This class provides methods for the identification of company-objects in
 * order to prevent "instanceof".
 * 
 * @author Tobias
 */
public abstract class Basic {

	/**
	 * @return true, if the object is a company.
	 */
	public boolean isCompany() {
		return false;
	}

	/**
	 * @return true, if the object is a department.
	 */
	public boolean isDepartment() {
		return false;
	}

	/**
	 * @return true, if the object is an employee.
	 */
	public boolean isEmployee() {
		return false;
	}
	
	public abstract void setName(String newName);
}
