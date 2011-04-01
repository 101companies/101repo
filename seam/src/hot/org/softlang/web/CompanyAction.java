package org.softlang.web;

import java.util.List;

import javax.faces.application.FacesMessage;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.faces.FacesMessages;
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
	
	@In
	private FacesMessages facesMessages;
	
	public void listAllCompanies() {
		allCompanies = companyService.listAllCompanies();
	}
	
	public String cutSalaries() {
		try {
			companyService.cutSalaries(selectedCompany);
			facesMessages.add(FacesMessage.SEVERITY_INFO, "The cut salary operation was successfully applied.");
		}
		catch(Exception e) {
			facesMessages.add(FacesMessage.SEVERITY_ERROR, "Error when trying to cut salaries. " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
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
