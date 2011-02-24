package org.softlang.hibernate;

import org.softlang.om.*;

public class Main {

	public static void main(String[] args) {
		
		// Comment out the following lines to just initialize the database

		System.out.println("Loading company...");
		Company c = Company.loadObject();
		System.out.println("Done.");

		System.out.println("Total salary = " + Total.total(c));

		System.out.println("Cutting...");
		Cut.cut(c);
		System.out.println("Done.");

		System.out.println("Save company...");
		c.saveObject();
		System.out.println("Done.");

		System.out.println("Reload Company...");
		c = Company.loadObject();
		System.out.println("Done.");

		System.out.println("New total salary = " + Total.total(c));
		
	}
}
