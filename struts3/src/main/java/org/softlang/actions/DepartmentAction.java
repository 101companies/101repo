package org.softlang.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.softlang.basics.Department;
import org.softlang.basics.Subunit;
import org.softlang.services.CompanyService;
import org.softlang.util.RequestUtil;

public class DepartmentAction {

	private Department department;
	
	
	@Action(value = "department.detail", 
			results = {@Result(name = "detail", location="department-detail.jsp")}
	)
	public String execute() {
		//the next assignment exposes the department 
		//member as a "bean", so that the forwarded jsp 
		//component is able to access its value. 
		department = CompanyService.instance().findDepartment(Long.parseLong(RequestUtil.getRequestParameter("dptId")));
		return "detail";
	}
	
	@Action(value = "department.detail", 
			results = {@Result(name = "detail", location="department-detail.jsp")}
	)
	public String cutSalariesOfSubunit() throws Exception {
		throw new Exception("This action has not been implemented yed!");
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
