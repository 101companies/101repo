package org.softlang.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import org.softlang.basics.Department;
import org.softlang.basics.Employee;
import org.softlang.basics.Subunit;
import org.softlang.services.CompanyService;
import org.softlang.util.RequestUtil;

public class EmployeeAction {
	private Employee employee;
	
	@Action(value = "employee.detail", 
			results = {@Result(name = "detail", location="employee-details.jsp")}
	)
	public String execute() {
		Long empId = Long.parseLong(RequestUtil.getRequestParameter("empId"));

		System.out.println("Employee: " + empId);
		
		Department department = CompanyService.instance().findDepartment(Long.parseLong(RequestUtil.getRequestParameter("dptId")));
		
		System.out.println("Department: " + department.getId());
		
		
		System.out.println();
		for (Subunit unit : department.getSubunits()) {
			if((!unit.isDepartment()) && (((Employee)unit).getId().equals(empId))) {
				employee = (Employee)unit;
			}
		}
		return "detail";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
