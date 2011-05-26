package org.softlang.server.company;

import org.softlang.shared.company.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * An employee has a name, an address, and a salary. 
 */
class EmployeeImpl extends UnicastRemoteObject implements Employee {

	private static final long serialVersionUID = -210889592677165250L;

	private String name;
	private String address;
	private double salary;

	protected EmployeeImpl() throws RemoteException {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void cut() {
		setSalary(getSalary() / 2);
	}	
}
