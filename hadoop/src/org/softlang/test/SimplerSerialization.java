package org.softlang.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.junit.Test;
import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

/**
 * We do a round-trip test for de-/serialization. That is, first, we create an
 * object in memory. Then, we write (say, serialize) the object. Then, we read
 * (say, de-serialize) the object. Finally, we compare original and read object
 * for structural equality.
 */
public class SimplerSerialization {

	public static Company createCompany() {

		// Create company
		Company company = new Company();
		company.setName("meganalysis");

		// Create all employees
		Employee craig = new Employee();
		craig.setName("Craig");
		craig.setAddress("Redmond");
		craig.setSalary(123456);
		craig.setCompany(company.getName());
		Employee erik = new Employee();
		erik.setName("Erik");
		erik.setAddress("Utrecht");
		erik.setSalary(12345);
		erik.setCompany(company.getName());
		Employee ralf = new Employee();
		ralf.setName("Ralf");
		ralf.setAddress("Koblenz");
		ralf.setSalary(1234);
		ralf.setCompany(company.getName());
		Employee ray = new Employee();
		ray.setName("Ray");
		ray.setAddress("Redmond");
		ray.setSalary(234567);
		ray.setCompany(company.getName());
		Employee klaus = new Employee();
		klaus.setName("Klaus");
		klaus.setAddress("Boston");
		klaus.setSalary(23456);
		klaus.setCompany(company.getName());
		Employee karl = new Employee();
		karl.setName("Karl");
		karl.setAddress("Riga");
		karl.setSalary(2345);
		karl.setCompany(company.getName());
		Employee joe = new Employee();
		joe.setName("Joe");
		joe.setAddress("Wifi City");
		joe.setSalary(2344);
		joe.setCompany(company.getName());

		// Create research department
		Department research = new Department();
		research.setManager(craig);
		research.setName("Research");
		research.getEmployees().add(erik);
		research.getEmployees().add(ralf);
		company.getDepts().add(research);

		// Create development department
		Department development = new Department();
		development.setManager(ray);
		development.setName("Development");
		company.getDepts().add(development);

		// Create sub-department dev1
		Department dev1 = new Department();
		development.getSubdepts().add(dev1);
		dev1.setName("Dev1");
		dev1.setManager(klaus);

		// Create sub-department dev11
		Department dev11 = new Department();
		dev1.getSubdepts().add(dev11);
		dev11.setName("Dev1.1");
		dev11.setManager(karl);
		dev11.getEmployees().add(joe);

		return company;
	}

	@Test
	public void testLoadAndCreate() throws IOException {
		Company sampleCompany = createCompany();

		// write company
		Configuration conf = new Configuration();
		Path companyOut = new Path("sampleCompany/megaanalysis/part-00000");
		FileSystem fs = companyOut.getFileSystem(conf);
		SequenceFile.Writer companyWriter = new SequenceFile.Writer(fs, conf,
				companyOut, Text.class, Company.class);
		companyWriter.append(sampleCompany.getName(), sampleCompany);
		companyWriter.close();

		// read company
		SequenceFile.Reader companyReader = new SequenceFile.Reader(fs, companyOut,
				conf);
		Text inName = new Text();
		Company inValue = new Company();
		companyReader.next(inName, inValue);

		assertTrue(sampleCompany.compareTo(inValue) == 0);
	}

}