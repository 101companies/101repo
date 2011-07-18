package org.softlang.service.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CompanyDTO implements Serializable {

	private static final long serialVersionUID = -7414339014375793083L;
	
	private String name;
	private List<DepartmentDTO> depts = new LinkedList<DepartmentDTO>();

	public String getName() {
		return name;
	}

	public List<DepartmentDTO> getDepts() {
		return depts;
	}
	
}