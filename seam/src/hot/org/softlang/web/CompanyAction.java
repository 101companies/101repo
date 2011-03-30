package org.softlang.web;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.softlang.model.Company;
import org.softlang.services.CompanyService;

@Name("companyAction")
@Scope(ScopeType.CONVERSATION)
public class CompanyAction {

	@In
	private CompanyService companyService;
	
	public List<Company> listAllCompanies() {
		return companyService.listAllCompanies();
	}
	
	public void cutSalaries(Integer cId) {
		//TODO: implement the cut salary logic here.
	}
}
