package org.softlang.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.Restrict;
import org.softlang.model.Company;
import org.softlang.model.Department;
import org.softlang.model.Employee;

@Name("companyService")
@Scope(ScopeType.CONVERSATION)
@AutoCreate
public class CompanyService {

	private static final String FIND_ALL_COMPANIES = "SELECT c FROM Company c";
	@In
	private EntityManager entityManager;
	
	public List<Company> listAllCompanies() {
		return entityManager.createQuery(FIND_ALL_COMPANIES).getResultList();
	}

	public Company find(Integer id) {
		return entityManager.find(Company.class, id);
	}
	
	public Department findDepartment(Integer id) {
		return entityManager.find(Department.class, id);
	}

	@Restrict("#{s:hasRole('admin')}") 
	public void cutSalaries(Company company) {
		company.cut();
		entityManager.merge(company);
	}

	@Restrict("#{s:hasRole('admin')}") 
	public void cutSalaries(Department department) {
		department.cut();
		entityManager.merge(department);
	}
	
	@Restrict("#{s:hasRole('admin')}") 
	public void cutSalaries(Employee employee) {
		employee.cut();
		entityManager.merge(employee);
	}
	
}
