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
	private Long deptId;
	
	@Action(value = "employee.detail", 
			results = {@Result(name = "detail", location="employee-details.jsp")}
	)
	public String execute() {
		Long empId = Long.parseLong(RequestUtil.getRequestParameter("empId"));
		
		deptId = Long.parseLong(RequestUtil.getRequestParameter("parentId"));
		
		employee = findEmployee(empId, deptId);
		
		
		return "detail";
	}
	
	@Action(value = "employee.update", 
			results = {@Result(name = "detail", location="employee-details.jsp")}
	)
	public String update() {
		Employee old = findEmployee(employee.getId(), deptId);
		
		old.setName(employee.getName());
		old.setAddress(employee.getAddress());
		old.setSalary(employee.getSalary());
		
		employee = old;
		
		return "detail";
	}

	private Employee findEmployee(Long empId, Long deptId) {
		Employee emp = null;
		
		Department department = CompanyService.instance().findDepartment(deptId);
		
		for (Subunit unit : department.getSubunits()) {
			if((!unit.isDepartment()) && (((Employee)unit).getId().equals(empId))) {
				emp = (Employee)unit;
			}
		}
		
		return emp;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	
	
	
	

}
