package org.softlang.swing;

import java.io.File;

import org.softlang.company.Company;

public class Test {
	public static void main(String[] args) {
		new GUI(Company.readObject(
					".."
				+ 	File.separator
				+	"alpha"
				+ 	File.separator
				+	"sampleCompany.ser"));
	}
}