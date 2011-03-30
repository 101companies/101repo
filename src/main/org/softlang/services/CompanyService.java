package org.softlang.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.softlang.model.Company;

@Name("companyService")
@Scope(ScopeType.CONVERSATION)
public class CompanyService {

	private static final String FIND_ALL_COMPANIES = "SELECT c FROM COMPANY";
	@In
	private EntityManager entityManager;
	
	public List<Company> listAllCompanies() {
		return entityManager.createQuery(FIND_ALL_COMPANIES).getResultList();
	}
}
