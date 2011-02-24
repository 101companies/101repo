package org.softlang.controller;

import org.softlang.model.*;

public interface Operation {
	
	public Dept searchDept(String name);

	public Employee searchEmployee(String name);

	public void updateDept(String deptName, Dept upDept);

	public void updateEmployee(String empName, Employee upEmpl);
}
