package org.softlang.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.softlang.basics.Company;
import org.softlang.services.CompanyService;
import org.softlang.util.RequestUtil;

/**
 * A class that implements several actions that could 
 * be refereed to within the view components (implemented as jsp files).
 * 
 * Here, we use an annotation based approach for declaring actions, 
 * instead of using XML files. 
 * 
 * Each action has a value property, a name that we use to make references 
 * to an action within an JSP component. Moreover, each action has a list of 
 * "results", that represent pairs that relate names to specific locations 
 * in our app. Locations could be either JSPs or other actions, in the case we 
 * want to "chain" two actions. The return string of an action method is used 
 * to match one of its results, forwarding the application to the "location" 
 * component.  
 * 
 * @author rbonifacio
 */
public class CompanyAction  {

	private Company company;

	@Action(value = "company.details", 
			results = { @Result(name = "detail", location = "company-detail.jsp") }
	)
	public String execute() {
		company = CompanyService.instance().findCompany(Long.parseLong(RequestUtil.getRequestParameter("id")));
		return "detail";
	}
	
	@Action(value = "company.cutSalaries",
			results = { @Result(name = "listAllCompanies", type="redirectAction", location="list-all-companies")} 
	)
	public String cutSalaries() {
		company = CompanyService.instance().findCompany(Long.parseLong(RequestUtil.getRequestParameter("id")));
		company.cut();
		return "listAllCompanies"; 
	}
		
	@Action(value = "company.cutSalariesOfDepartment", 
			results = { @Result(name = "detail", location = "company-detail.jsp") }
	)
	public String cutSalariesOfDepartment() {
		CompanyService.instance().findDepartment(Long.parseLong(RequestUtil.getRequestParameter("dptId"))).cut();
		company = CompanyService.instance().findCompany(Long.parseLong(RequestUtil.getRequestParameter("cmpId")));
		return "detail";
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
