package org.softlang.company;

import java.io.Serializable;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * An employee has a salary and some person information
 * 
 */
public class Employee implements Serializable {

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
		DefaultMutableTreeNode addressNode = (DefaultMutableTreeNode) treeNode.getChildAt(0);
		addressNode.setUserObject("Address: " + getAddress());
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
		DefaultMutableTreeNode addressNode = (DefaultMutableTreeNode) treeNode.getChildAt(1);
		addressNode.setUserObject("Salary: " + getSalary());
	}
	
	public void setManager(boolean m) {
		this.manager = m;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * eingefügt um den Namen zurückzugeben
	 * produziert den String auf eine feste Länge
	 */
	public String toString(){
		String treeName = this.getName();
//		if(treeName.length() < 15){
//			for(int i = treeName.length(); i<15 ;i++){
//				treeName += " ";
//			}
//		}
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
}
