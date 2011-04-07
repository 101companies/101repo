package de.uni_koblenz.oneoonecompanies;

import de.uni_koblenz.oneoonecompanies.schema.CompaniesGraph;
import de.uni_koblenz.oneoonecompanies.schema.Company;
import de.uni_koblenz.oneoonecompanies.schema.Department;
import de.uni_koblenz.oneoonecompanies.schema.Employee;
import de.uni_koblenz.oneoonecompanies.schema.Manager;
import de.uni_koblenz.oneoonecompanies.schema.OneOOneSchema;

public class CompanyCreator {
	static CompaniesGraph createCompanyGraph() {
		CompaniesGraph g = OneOOneSchema.instance().createCompaniesGraph();

		Company compMeganalysis = g.createCompany();
		compMeganalysis.set_name("Meganalysis");

		Department researchDept = g.createDepartment();
		researchDept.set_name("ResearchDept");
		compMeganalysis.add_departments(researchDept);

		Manager managerCraig = g.createManager();
		managerCraig.set_name("Craig");
		managerCraig.set_address("Redmond");
		managerCraig.set_salary(123456);
		researchDept.add_persons(managerCraig);

		Employee erik = g.createEmployee();
		erik.set_name("Erik");
		erik.set_address("Utrecht");
		erik.set_salary(12345);
		researchDept.add_persons(erik);

		Employee ralf = g.createEmployee();
		ralf.set_name("Ralf");
		ralf.set_address("Koblenz");
		ralf.set_salary(1234);
		researchDept.add_persons(ralf);

		Department develDept = g.createDepartment();
		develDept.set_name("DevelopmentDept");
		compMeganalysis.add_departments(develDept);

		Manager ray = g.createManager();
		ray.set_name("Ray");
		ray.set_address("Redmond");
		ray.set_salary(234567);
		develDept.add_persons(ray);

		Department dev1Dept = g.createDepartment();
		dev1Dept.set_name("Dev 1");
		develDept.add_subDepts(dev1Dept);

		Manager klaus = g.createManager();
		klaus.set_name("Klaus");
		klaus.set_address("Boston");
		klaus.set_salary(23456);
		klaus.add_department(dev1Dept);

		Department dev1_1Dept = g.createDepartment();
		dev1_1Dept.set_name("Dev 1.1");

		Manager karl = g.createManager();
		karl.set_name("Karl");
		karl.set_address("Riga");
		karl.set_salary(2345);
		karl.add_department(dev1_1Dept);

		Employee joe = g.createEmployee();
		joe.set_name("Joe");
		joe.set_address("WiFiCity");
		joe.set_salary(2344);
		joe.add_department(dev1_1Dept);

		return g;
	}
}
