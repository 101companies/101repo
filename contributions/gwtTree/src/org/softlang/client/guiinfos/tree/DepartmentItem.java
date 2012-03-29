package org.softlang.client.guiinfos.tree;

import java.io.Serializable;
import java.util.List;

public class DepartmentItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3443697446426121170L;

	private String name;
	private Integer id;
	private List<DepartmentItem> departments;
	private List<EmployeeItem> employees;
	private String faultMessage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<DepartmentItem> getDepartments() {
		return departments;
	}
	
	public List<EmployeeItem> getEmployees() {
		return employees;
	}

	public void setDepartments(List<DepartmentItem> departments) {
		this.departments = departments;
	}

	public void setEmployees(List<EmployeeItem> employees) {
		this.employees = employees;
	}

	public String getFaultMessage() {
		return faultMessage;
	}

	public void setFaultMessage(String faultMessage) {
		this.faultMessage = faultMessage;
	}

	public boolean isFault() {
		return faultMessage != null;
	}

}
