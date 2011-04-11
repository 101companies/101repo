package org.softlang.services;

import java.util.ArrayList;
import java.util.List;

import org.softlang.basics.Company;

public class CompanyService {

	public static List<Company> listAllCompanies() {
		List<Company> companies = new ArrayList<Company>();
		
		Company company = Company.readObject("sampleCompany.ser");
		companies.add(company);
		
		return companies;
	}
}
