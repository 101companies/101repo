package org.softlang.company;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Department extends Basic implements Serializable {

	private static final long serialVersionUID = -2008895922177165250L;
	private String name;
	private Employee manager;
	private List<Department> subdepts;
	private List<Employee> employees;
	private DefaultMutableTreeNode treeNode;

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

	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString() {
		String treeName = this.getName();
		return treeName;
	}

	public void setTreeNode(DefaultMutableTreeNode treeNode) {
		this.treeNode = treeNode;
	}

	public DefaultMutableTreeNode getTreeNode() {
		return treeNode;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.softlang.company.Basic#isDepartment()
	 */
	@Override
	public boolean isDepartment() {
		return true;
	}
}
