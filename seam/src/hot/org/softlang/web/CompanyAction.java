package org.softlang.web;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.softlang.model.Company;
import org.softlang.model.Department;
import org.softlang.services.CompanyService;

@Name("companyAction")
@Scope(ScopeType.CONVERSATION)
@AutoCreate
public class CompanyAction {

	@In //here, we are saying that a container should inject the company service from conversation
	private CompanyService companyService;
	
	@Out(required=false) //here we are saying that we are exposing company to the conversation
	Company company;
	
	@Out(required=false) 
	Department department;

	@DataModel
	private List<Company> allCompanies;
	
	@DataModelSelection
	private Company selectedCompany;
	
	public void listAllCompanies() {
		allCompanies = companyService.listAllCompanies();
	}
	
	public void cutSalaries() {
		//TODO: implement the cut salary logic here.
	}
	
	public String showDetails() {	
		company = selectedCompany;
		return "showCompanyDetails";
	}
	
	public String showDepartmentDetails(Department d) {
		department = companyService.findDepartment(d.getId());
		
		return "showDepartmentDetails";
	}
}
