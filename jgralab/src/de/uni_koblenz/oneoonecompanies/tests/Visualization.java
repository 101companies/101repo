package de.uni_koblenz.oneoonecompanies.tests;

import de.uni_koblenz.oneoonecompanies.CompanyServices;
import de.uni_koblenz.oneoonecompanies.schema.Company;

public class Visualization {
	
	public static void main(String[] args) {
		CompanyServices api = CompanyServices.instance();
		api.loadGraph("sampleCompany.tg");
		Company meganalysis = api.getCompany("meganalysis");
		api.addMentor(meganalysis, "Ray", "Joe");
		api.addMentor(meganalysis, "Craig", "Ralf");
		api.visualizeGraph("sampleCompany.png");
	}
}
