package org.softlang.company;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * eingefügt um den Namen zurückzugeben
	 * produziert den String auf eine feste Länge
	 */
	public String toString() {
		String treeName = this.getName();
		if(treeName.length() < 15){
			for(int i = treeName.length(); i<15 ;i++){
				treeName += " ";
			}
		}
		return treeName;
	}

	public void setTreeNode(DefaultMutableTreeNode treeNode) {
		this.treeNode = treeNode;
	}

	public DefaultMutableTreeNode getTreeNode() {
		return treeNode;
	}
}
