package org.softlang.service.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.*;

import org.softlang.service.company.Department;
import org.softlang.service.company.Employee;

@XmlRootElement
public class DepartmentDTO implements Serializable {

	private static final long serialVersionUID = 1927670852143966923L;
	
	@XmlAttribute
	private String name;
	@XmlElement
	private EmployeeDTO manager;
	 
	@XmlElement
	private List<DepartmentDTO> subdepts = new LinkedList<DepartmentDTO>();
	@XmlElement
	private List<EmployeeDTO> employees = new LinkedList<EmployeeDTO>();

	public DepartmentDTO() {
	}
	
	public DepartmentDTO(Department dep) {
		this.name = dep.getName();
		this.manager = new EmployeeDTO(dep.getManager());
		
		for (Department subdep : dep.getSubdepts()) {
			this.subdepts.add(new DepartmentDTO(subdep));
		}
		
		for (Employee emp : dep.getEmployees()) {
			this.employees.add(new EmployeeDTO(emp));
		}
	}
	
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