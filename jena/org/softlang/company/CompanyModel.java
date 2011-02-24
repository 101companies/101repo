package org.softlang.company;

import com.hp.hpl.jena.rdf.model.*;

/**
 * This is a class for company RDF models, i.e., enriched RDF models.
 * Such models provide properties needed for a company model.
 * Such models also provide factory methods for company RDF resources.
 */
public class CompanyModel {

	private Model model;

	public final String NS_COMPANY = "http://www.company.com/ns#";

	public final Property DEPTS;
	public final Property DNAME;
	public final Property MANAGER;
	public final Property EMPLOYEES;
	public final Property PU;
	public final Property DU;
	public final Property SALARY;
	public final Property PERSON;
	public final Property MENTOR;
	public final Property PNAME;
	public final Property ADDRESS;
	
	public CompanyModel(){
		model = ModelFactory.createDefaultModel();

		DEPTS = model.createProperty(NS_COMPANY + "depts");
		DNAME = model.createProperty(NS_COMPANY + "dName");
		MANAGER = model.createProperty(NS_COMPANY + "manager");
		EMPLOYEES = model.createProperty(NS_COMPANY + "employees");
		PU = model.createProperty(NS_COMPANY + "pu");
		DU = model.createProperty(NS_COMPANY + "du");
		SALARY = model.createProperty(NS_COMPANY + "salary");
		PERSON = model.createProperty(NS_COMPANY + "person");
		MENTOR = model.createProperty(NS_COMPANY + "mentor");
		PNAME = model.createProperty(NS_COMPANY + "pName");
		ADDRESS = model.createProperty(NS_COMPANY + "address");
	}
	
	public Model getModel(){
		return model;
	}
	
	public Resource createCompany(Container depts) {
		return model.createResource().
			addProperty(
					DEPTS, 
					depts);
	}
	
	public Resource createDept(String uri,String dName, Resource manager, Container employees, Container depts){
		return model.createResource(uri).
			addLiteral(
					DNAME,
					dName).
			addProperty(
					MANAGER,
					manager).
			addProperty(
					EMPLOYEES,
					employees).
			addProperty(
					DEPTS, 
					depts);
	}
	
	public Resource createEmployee(String uri, Resource person, Double salary, Resource mentor){
		Resource employee =  model.createResource(uri).
			addLiteral(
					SALARY, 
					salary).
			addProperty(
					PERSON, 
					person);
		if (mentor!=null)
			employee.addProperty(
					MENTOR,
					mentor);
		return employee; 
	}
	
	public Resource createPerson(String pName, String pAddress){
		return model.createResource().
			addLiteral(
					PNAME, 
					pName).
			addLiteral(
					ADDRESS, 
					pAddress);
	}
}
