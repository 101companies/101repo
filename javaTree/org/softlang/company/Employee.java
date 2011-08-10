package org.softlang.company;

import java.io.Serializable;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * An employee has a salary and some person information
 * 
 */
public class Employee extends Basic implements Serializable {

	private static final long serialVersionUID = -210889592677165250L;

	private String name;
	private String address;
	private double salary;
	private DefaultMutableTreeNode treeNode;
	
	private boolean manager = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void setManager(boolean m) {
		this.manager = m;
	}
	
	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString(){
		String treeName = this.getName();
		if (manager) {
			return treeName + " (Manager)";
		}
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
	 * @see org.softlang.company.Basic#isEmployee()
	 */
	@Override
	public boolean isEmployee() {
		return true;
	}
}
