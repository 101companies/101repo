package org.softlang.server.company;

import org.softlang.shared.company.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 * A company has a name and consists of (possibly nested) departments.
 */
class CompanyImpl extends UnicastRemoteObject implements Company {

	private static final long serialVersionUID = -200889592677165250L;
	
	private String name;
	private List<Department> depts = new LinkedList<Department>();

	protected CompanyImpl() throws RemoteException {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepts() {
		return depts;
	}
	
	public Double total() throws RemoteException {
		double total = 0;
		for (Department d : getDepts())
			total += d.total();
		return total;
	}	
	
	public void cut() throws RemoteException {
		for (Department d : getDepts())
			d.cut();
	}	
}
