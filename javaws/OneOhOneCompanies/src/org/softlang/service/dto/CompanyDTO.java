package org.softlang.service.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.*;

import org.softlang.service.company.Company;
import org.softlang.service.company.Department;

	@XmlRootElement
	public class CompanyDTO implements Serializable {

	private static final long serialVersionUID = -7414339014375793083L;
	
	@XmlAttribute
	private String name;
	@XmlElement
	private List<DepartmentDTO> depts = new LinkedList<DepartmentDTO>();

	public CompanyDTO() {
	}
	
	public CompanyDTO(Company comp) {
		this.name = comp.getName();
		
		for (Department dep : comp.getDepts()) {
			this.depts.add(new DepartmentDTO(dep));
		}
	}
	
	public String getName() {
		return name;
	}

	public List<DepartmentDTO> getDepts() {
		return depts;
	}
	
}