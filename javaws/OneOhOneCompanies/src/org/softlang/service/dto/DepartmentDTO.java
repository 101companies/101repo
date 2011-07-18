package org.softlang.service.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class DepartmentDTO implements Serializable {

	private static final long serialVersionUID = 1927670852143966923L;
	
	private String name;
	private EmployeeDTO manager;
	private List<DepartmentDTO> subdepts = new LinkedList<DepartmentDTO>();
	private List<EmployeeDTO> employees = new LinkedList<EmployeeDTO>();

	public String getName() {
		return name;
	}

	public EmployeeDTO getManager() {
		return manager;
	}

	public List<DepartmentDTO> getSubdepts() {
		return subdepts;
	}

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}
		
}