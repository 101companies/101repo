package org.softlang.server.company;

import java.rmi.RemoteException;

import org.softlang.shared.company.*;

public class Factory {

	public static Company mkCompany() throws RemoteException { return new CompanyImpl(); }	
	public static Department mkDepartment() throws RemoteException { return new DepartmentImpl(); }	
	public static Employee mkEmployee() throws RemoteException { return new EmployeeImpl(); }	
	
}
