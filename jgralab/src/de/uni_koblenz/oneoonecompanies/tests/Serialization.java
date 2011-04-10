package de.uni_koblenz.oneoonecompanies.tests;

import java.io.File;

import de.uni_koblenz.jgralab.GraphIOException;
import de.uni_koblenz.oneoonecompanies.schema.CompaniesGraph;
import de.uni_koblenz.oneoonecompanies.schema.Company;
import de.uni_koblenz.oneoonecompanies.schema.Department;
import de.uni_koblenz.oneoonecompanies.schema.Employee;
import de.uni_koblenz.oneoonecompanies.schema.Manager;
import de.uni_koblenz.oneoonecompanies.schema.OneOOneSchema;
import org.junit.Test;

public class Serialization {
	
	static CompaniesGraph createSampleGraph() {
		
		CompaniesGraph g = 
			OneOOneSchema.
			instance().
			createCompaniesGraph();
	
		Company meganalysis = g.createCompany();
		meganalysis.set_name("meganalysis");

		Department research = g.createDepartment();
		research.set_name("Research");
		meganalysis.add_departments(research);

		Manager craig = g.createManager();
		craig.set_name("Craig");
		craig.set_address("Redmond");
		craig.set_salary(123456);
		research.add_persons(craig);

		Employee erik = g.createEmployee();
		erik.set_name("Erik");
		erik.set_address("Utrecht");
		erik.set_salary(12345);
		research.add_persons(erik);

		Employee ralf = g.createEmployee();
		ralf.set_name("Ralf");
		ralf.set_address("Koblenz");
		ralf.set_salary(1234);
		research.add_persons(ralf);

		Department development = g.createDepartment();
		development.set_name("Development");
		meganalysis.add_departments(development);

		Manager ray = g.createManager();
		ray.set_name("Ray");
		ray.set_address("Redmond");
		ray.set_salary(234567);
		development.add_persons(ray);

		Department dev1 = g.createDepartment();
		dev1.set_name("Dev 1");
		development.add_subDepts(dev1);

		Manager klaus = g.createManager();
		klaus.set_name("Klaus");
		klaus.set_address("Boston");
		klaus.set_salary(23456);
		klaus.add_department(dev1);

		Department dev11 = g.createDepartment();
		dev11.set_name("Dev 1.1");
		g.createHasSubDepartment(dev1, dev11);

		Manager karl = g.createManager();
		karl.set_name("Karl");
		karl.set_address("Riga");
		karl.set_salary(2345);
		karl.add_department(dev11);

		Employee joe = g.createEmployee();
		joe.set_name("Joe");
		joe.set_address("WiFi City");
		joe.set_salary(2344);
		joe.add_department(dev11);

		return g;
	}
	
	@Test
	public void writeSampleCompany() {
		
		CompaniesGraph g = createSampleGraph();
		try {
			OneOOneSchema.
			instance().
			saveCompaniesGraph(
				new File("sampleCompany.tg").getPath(), g);
		} catch (GraphIOException e) {
			e.printStackTrace();
		}

	}
}
