package org.softlang.actions;

import java.util.List;

import org.softlang.basics.Company;
import org.softlang.services.CompanyService;

/**
 * A simple struts action for listing all companies.
 * 
 * Using the struts convention plugin, we 
 * are able to refer to this action by "list-all-companies", 
 * at any jsp component. 
 * 
 * @author rbonifacio
 */
public class ListAllCompaniesAction {

	private List<Company> allCompanies;

	public String execute() {
		allCompanies = CompanyService.listAllCompanies();
		return "SUCCESS";
	}

	public List<Company> getAllCompanies() {
		return allCompanies;
	}

	public void setAllCompanies(List<Company> allCompanies) {
		this.allCompanies = allCompanies;
	}
	
}
