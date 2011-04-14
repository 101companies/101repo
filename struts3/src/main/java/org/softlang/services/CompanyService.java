package org.softlang.services;

import java.util.ArrayList;
import java.util.List;

import org.softlang.basics.Company;
import org.softlang.basics.Department;

public class CompanyService {

	private List<Company> companies;
	
	/* singleton instance of the CompanyService class */
	private static CompanyService instance;
	
	/**
	 * Returns the unique instance of CompanyService.
	 */
	public static CompanyService instance() {
		if(instance == null) {
			instance = new CompanyService();
		}
		return instance;
	}
	
	/**
	 * Return all companies
	 */
	public List<Company> listAllCompanies() {
		if(companies == null || companies.size() == 0) {
			companies = new ArrayList<Company>();
			Company company = Company.readObject("sampleCompany.ser");
			companies.add(company);
		}
		
		return companies;
	}
	
	/**
	 * Find a company whose name is informed as an argument.	
	 */
	@Deprecated
	public Company findCompany(String name) {
		for (Company c : listAllCompanies()) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
	
	public Company findCompany(Long id) {
		for (Company c : listAllCompanies()) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Cuts the salary of the company, whose name 
	 * is informed as an argument.
	 */
	public void cutSalary(String name) throws Exception {
		Company c = findCompany(name);
		if(c == null) {
			throw new Exception("Company " + name + " not found. Unable to cut its salaries");
		}
		c.cut();
	}
	
	public Department findDepartment(Long id) {
		for (Company c : listAllCompanies()) {
			Department d = c.findDepartment(id);
			if(d != null) {
				return d;
			}
		}
		return null;
	}

}
