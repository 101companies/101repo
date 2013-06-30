package org.softlang.company.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Employee extends Remote {
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException;
	String getAddress() throws RemoteException;
	void setAddress(String address) throws RemoteException;
	double getSalary() throws RemoteException;
	void setSalary(double salary) throws RemoteException;
}
