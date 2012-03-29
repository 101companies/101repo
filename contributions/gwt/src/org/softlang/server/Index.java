package org.softlang.server;

import org.softlang.server.company.*;
import java.util.HashMap;

/**
 * Provide an index for all nodes in a company tree
 * so that node ids (say, names of departments and employees)
 * can be used to look up the corresponding node in the tree.
 */
public class Index {

	// mapping of department ids (say, names) to server-side department objects
	private HashMap<String, Dept> deptMap;

	// mapping of employee ids (say, names) to server-side employee objects
	private HashMap<String, Employee> employeeMap;

	public Index() {
		deptMap = new HashMap<String, Dept>();
		employeeMap = new HashMap<String, Employee>();
	}

	/**
	 * Index all nodes in the company tree for look-up by id (say, name)
	 */
	public void index(Company company) {
		for (Dept dept : company.getDepts())
			index(dept);
	}

	private void index(Dept dept) {
		deptMap.put(dept.getName(), dept);
		index(dept.getManager());
		for (Subunit subunit : dept.getSubunits()) {
			if (subunit.getPu() != null)
				index(subunit.getPu());
			else
				index(subunit.getDu());
		}
	}

	private void index(Employee employee) {
		employeeMap.put(employee.getPerson().getName(), employee);
	}

	/**
	 * Return the mapping of department ids (say, names) to server-side department objects.
	 */
	public HashMap<String, Dept> getDeptMap() {
		return deptMap;
	}
	
	/**
	 * Return the mapping of employee ids (say, names) to server-side employee objects.
	 */
	public HashMap<String, Employee> getEmployeeMap() {
		return employeeMap;
	}

}
