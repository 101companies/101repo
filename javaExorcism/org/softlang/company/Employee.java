package org.softlang.company;

/**
 * An employee has a name, an address, and a salary. 
 * Also, an employee may be flagged to be a manager.
 */
public interface Employee extends Subunit {
	String getAddress();
	void setAddress(String address);
	double getSalary();
	void setSalary(double salary);
	boolean getManager();
	void setManager(boolean manager);
}
