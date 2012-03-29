package org.softlang.tests;

import org.softlang.swing.GUI;
import org.softlang.company.Company;

public class Interaction {
	public static void main(String[] args) {
		// The serialized object has been copied over from elsewhere
		new GUI(Company.readObject("sampleCompany.ser"));
	}
}