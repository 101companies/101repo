package org.softlang.shared.company;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Department extends Remote {
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException;
	Employee getManager() throws RemoteException;
	void setManager(Employee manager) throws RemoteException;
	List<Department> getSubdepts() throws RemoteException;
	List<Employee> getEmployees() throws RemoteException;
	double total() throws RemoteException;
	void cut() throws RemoteException;
}
