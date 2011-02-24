package org.softlang.hibernate;

import org.softlang.om.*;

public class Main {

	public static void main(String[] args) {

		HibernateConnectivity hc = new HibernateConnectivity();
		
		// Comment out the following lines to just initialize the database

		System.out.println("Loading company...");
		Company company = hc.loadCompany();
		System.out.println("Done.");

		System.out.println("Total salary = " + Total.total(company));

		System.out.println("Cutting...");
		Cut.cut(company);
		System.out.println("Done.");

		System.out.println("Save company...");
		hc.saveCompany(company);
		System.out.println("Done.");

		System.out.println("Reload Company...");
		company = hc.loadCompany();
		System.out.println("Done.");

		System.out.println("New total salary = " + Total.total(company));
		
		//
	}
}
