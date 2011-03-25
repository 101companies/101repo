package org.softlang.swing;

import org.softlang.company.Company;

public class Test {
	public static void main(String[] args) {
		// The serialized object has been copied over from elsewhere
		new GUI(Company.readObject("sampleCompany.ser"));
	}
}