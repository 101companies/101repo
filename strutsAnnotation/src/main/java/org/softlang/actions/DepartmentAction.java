package org.softlang.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.softlang.basics.Department;
import org.softlang.basics.Employee;
import org.softlang.basics.Subunit;
import org.softlang.services.CompanyService;
import org.softlang.util.RequestUtil;

public class DepartmentAction {

	private Department department;
	private String message;
	
	
	@Action(value = "department.detail", 
			results = {@Result(name = "detail", location="department-detail.jsp")}
	)
	public String execute() {
		//the next assignment exposes the department 
		//member as a "bean", so that the forwarded view (a JSP) 
		//component is able to access its value. 
		department = CompanyService.instance().findDepartment(Long.parseLong(RequestUtil.getRequestParameter("dptId")));
		return "detail";
	}
	
	@Action(value = "department.cutSalariesOfDepartment", 
			results = {@Result(name = "detail", location="department-detail.jsp")}
	)
	public String cutSalariesOfSubunit() throws Exception {	
		department = CompanyService.instance().findDepartment(department.getId());
		department.cut();
		return "detail";
	}

	
    @Action(value = "department.update", 
		    results = {@Result(name = "detail", location="department-detail.jsp")}
	) 
	public String update() {
	    //ok, it might sound a bit redundant, but if we change the 
        //persistence mechanism to a database, all these 
        //lines would be necessary.
        	
        Department old = CompanyService.instance().findDepartment(department.getId());
	    
	    old.setName(department.getName());
	    old.setManager(department.getManager());
	    
	    department = old;
	    message = "The department data was updated."; 
	    return "detail";
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
