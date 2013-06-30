package org.softlang.company.server;

import java.rmi.RemoteException;

import org.softlang.company.shared.*;

public class Factory {

	public static Company mkCompany() throws RemoteException { return new CompanyImpl(); }	
	public static Department mkDepartment() throws RemoteException { return new DepartmentImpl(); }	
	public static Employee mkEmployee() throws RemoteException { return new EmployeeImpl(); }	
	
}
