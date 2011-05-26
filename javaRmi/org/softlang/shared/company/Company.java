package org.softlang.shared.company;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Company extends Remote {
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException;
	List<Department> getDepts() throws RemoteException;
	Double total() throws RemoteException;
	void cut() throws RemoteException;	
}
