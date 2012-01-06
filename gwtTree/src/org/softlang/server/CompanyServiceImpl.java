package org.softlang.server;

import org.softlang.client.guiinfos.CompanyInfo;
import org.softlang.client.interfaces.CompanyService;
import org.softlang.server.company.Company;
import org.softlang.shared.ServerValidationException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CompanyServiceImpl extends RemoteServiceServlet implements CompanyService {

	/**
	 * automatically generated serial-version UID
	 */
	private static final long serialVersionUID = -4414941964797293399L;

	@Override
	public double cut(Integer id) {
		Company company = CompanyApp.getInstance().getCompanies().get(id);
		
		company.cut();
		
		return company.total();
	}

	@Override
	public CompanyInfo getCompany(Integer id) {
		CompanyInfo result = new CompanyInfo();
		
		Company company = CompanyApp.getInstance().getCompanies().get(id);
		
		result.setId(company.getId());
		result.setName(company.getName());
		result.setTotal(company.total());
		
		return result;
	}

	@Override
	public String saveCompany(Integer id, String name) throws ServerValidationException {
		CompanyApp.getInstance().validateCompany(id, name);
		
		Company company = CompanyApp.getInstance().getCompanies().get(id);
		
		company.setName(name);
		
		return CompanyApp.getInstance().getCompanies().get(id).getName();
	}


	
}
