package org.softlang.company;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Department implements Serializable {

	private static final long serialVersionUID = -2008895922177165250L;
	private String name;
	private Employee manager;
	private List<Department> subdepts;
	private List<Employee> employees;

	public Department() {
		subdepts = new LinkedList<Department>();
		employees = new LinkedList<Employee>();
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
	
	public double total() {
		double total = 0;
		total += getManager().total();
		for (Department s : getSubdepts())
			total += s.total();
		for (Employee e : getEmployees())
			total += e.total();
		return total;		
	}	
		
	public void cut() {
		getManager().cut();
		for (Department s : getSubdepts())
			s.cut();
		for (Employee e : getEmployees())
			e.cut();
	}	

}
