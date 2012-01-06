package org.softlang.client.guiinfos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7339458164866881122L;
	
	private Integer id;
	private String name;
	private String address;
	private double total;
	private Integer parent;
	private Map<Integer, String> allDepartments;
	private List<String> faults;
	
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
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Integer getParent() {
		return parent;
	}
	
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	
	public Map<Integer, String> getAllDepartments() {
		return allDepartments;
	}
	
	public void setAllDepartments(Map<Integer, String> departments) {
		this.allDepartments = departments;
	}

	public boolean isNewEmployee() {
		return id == null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<String> getFaultMessage() {
		return faults;
	}

	public void addFaultMessage(String faultMessage) {
		if (faults == null) {
			this.faults = new ArrayList<String>();
		}
		faults.add(faultMessage);
	}

	public boolean isFault() {
		return faults != null && faults.size() > 0;
	}
}
