package org.softlang.aspectJ.tests;

import org.softlang.company.*;

public class SampleCompany {

	public static Company getSampleCompany() {
		Company meganalysis = new Company();

		meganalysis.setName("meganalysis");

		Person craig = new Person();
		craig.setName("Craig");
		craig.setAddress("Redmond");
		Person erik = new Person();
		erik.setName("Erik");
		erik.setAddress("Utrecht");
		Person ralf = new Person();
		ralf.setName("Ralf");
		ralf.setAddress("Koblenz");
		Person ray = new Person();
		ray.setName("Ray");
		ray.setAddress("Redmond");
		Person klaus = new Person();
		klaus.setName("Klaus");
		klaus.setAddress("Boston");
		Person karl = new Person();
		karl.setName("Karl");
		karl.setAddress("Riga");
		Person joe = new Person();
		joe.setName("Joe");
		joe.setAddress("Wifi City");

		Employee CraigE = new Employee();
		Employee erikE = new Employee();
		Employee ralfE = new Employee();
		Employee rayE = new Employee();
		Employee klausE = new Employee();
		Employee karlE = new Employee();
		Employee joeE = new Employee();

		CraigE.setPerson(craig);
		erikE.setPerson(erik);
		ralfE.setPerson(ralf);
		rayE.setPerson(ray);
		klausE.setPerson(klaus);
		karlE.setPerson(karl);
		joeE.setPerson(joe);

		CraigE.setSalary(123456);
		erikE.setSalary(12345);
		ralfE.setSalary(1234);
		rayE.setSalary(234567);
		klausE.setSalary(23456);
		karlE.setSalary(2345);
		joeE.setSalary(2344);

		Dept research = new Dept();
		Subunit researchS1 = new Subunit();
		Subunit researchS2 = new Subunit();

		research.setManager(CraigE);
		research.setName("Research");
		researchS1.setEu(erikE);
		researchS2.setEu(ralfE);
		research.getSubunits().add(researchS1);
		research.getSubunits().add(researchS2);

		Dept development = new Dept();
		development.setManager(rayE);
		development.setName("Development");
		Subunit developmentS1 = new Subunit();
		development.getSubunits().add(developmentS1);
		Dept dev1 = new Dept();
		dev1.setName("Dev1");
		dev1.setManager(klausE);
		developmentS1.setDu(dev1);
		Subunit dev1S1 = new Subunit();
		dev1.getSubunits().add(dev1S1);
		Dept dev11 = new Dept();
		dev11.setName("Dev1.1");
		dev11.setManager(karlE);
		dev1S1.setDu(dev11);
		Subunit dev11S1 = new Subunit();
		dev11S1.setEu(joeE);
		dev11.getSubunits().add(dev11S1);

		meganalysis.getDepts().add(research);
		meganalysis.getDepts().add(development);

		return meganalysis;

	}

}
