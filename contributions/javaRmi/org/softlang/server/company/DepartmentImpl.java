package org.softlang.server.company;

import org.softlang.shared.company.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 * A department has a name, a manager, employees, and subdepartments.
 */
class DepartmentImpl extends UnicastRemoteObject implements Department {

	private static final long serialVersionUID = -2008895922177165250L;
	
	private String name;
	private Employee manager;
	private List<Department> subdepts = new LinkedList<Department>();
	private List<Employee> employees = new LinkedList<Employee>();

	protected DepartmentImpl() throws RemoteException {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Department> getSubdepts() {
		return subdepts;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	public double total() throws RemoteException {
		double total = 0;
		total += getManager().getSalary();
		for (Department s : getSubdepts())
			total += s.total();
		for (Employee e : getEmployees())
			total += e.getSalary();
		return total;		
	}	
	
	public void cut() throws RemoteException {
		getManager().cut();
		for (Department s : getSubdepts())
			s.cut();
		for (Employee e : getEmployees())
			e.cut();
	}	
}
