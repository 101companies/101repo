package org.softlang.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
 * We create a sample {@link Company} along with some {@link Deptartments} and
 * some {@link Employees}. These are serialized to disk using Hadoop's
 * {@link SequenceFile}.
 */
public class Serialization {

	public static boolean createAndWriteCompany(String filename) {

		LinkedList<Department> depts = new LinkedList<Department>();
		LinkedList<Employee> empl = new LinkedList<Employee>();

		// Create company
		Company company = new Company();
		company.setName("meganalysis");

		// Create all employees
		Employee craig = new Employee();
		craig.setName("Craig");
		craig.setAddress("Redmond");
		craig.setSalary(123456);
		craig.setCompany(company.getName());
		empl.add(craig);

		Employee erik = new Employee();
		erik.setName("Erik");
		erik.setAddress("Utrecht");
		erik.setSalary(12345);
		erik.setCompany(company.getName());
		empl.add(erik);

		Employee ralf = new Employee();
		ralf.setName("Ralf");
		ralf.setAddress("Koblenz");
		ralf.setSalary(1234);
		ralf.setCompany(company.getName());
		empl.add(ralf);

		Employee ray = new Employee();
		ray.setName("Ray");
		ray.setAddress("Redmond");
		ray.setSalary(234567);
		ray.setCompany(company.getName());
		empl.add(ray);

		Employee klaus = new Employee();
		klaus.setName("Klaus");
		klaus.setAddress("Boston");
		klaus.setSalary(23456);
		klaus.setCompany(company.getName());
		empl.add(klaus);

		Employee karl = new Employee();
		karl.setName("Karl");
		karl.setAddress("Riga");
		karl.setSalary(2345);
		karl.setCompany(company.getName());
		empl.add(karl);

		Employee joe = new Employee();
		joe.setName("Joe");
		joe.setAddress("Wifi City");
		joe.setSalary(2344);
		joe.setCompany(company.getName());
		empl.add(joe);

		// Create research department
		Department research = new Department();
		research.setName("Research");
		research.setCompany(company.getName());
		depts.add(research);

		craig.setDepartment(research.getName());
		craig.setManager(true);
		erik.setDepartment(research.getName());
		ralf.setDepartment(research.getName());

		// Create development department
		Department development = new Department();
		development.setName("Development");
		development.setCompany(company.getName());
		depts.add(development);

		ray.setDepartment(development.getName());
		ray.setManager(true);

		// Create sub-department dev1
		Department dev1 = new Department();
		dev1.setName("Dev1");
		dev1.setCompany(company.getName());
		dev1.setSuperDept(development.getName());
		depts.add(dev1);

		klaus.setDepartment(dev1.getName());
		klaus.setManager(true);

		// Create sub-department dev11
		Department dev11 = new Department();
		dev11.setName("Dev1.1");
		dev11.setCompany(company.getName());
		dev11.setSuperDept(dev1.getName());
		depts.add(dev11);

		karl.setDepartment(dev11.getName());
		karl.setManager(true);
		joe.setDepartment(dev11.getName());

		// write
		Configuration conf = new Configuration();
		FileSystem fs;

		Path companyFile = new Path(filename + "/companies");
		Path departmentFile = new Path(filename + "/departments");
		Path employeeFile = new Path(filename + "/employees");
		try {
			// write company
			fs = companyFile.getFileSystem(conf);
			SequenceFile.Writer companyWriter = SequenceFile.createWriter(fs, conf,
					companyFile, Text.class, Company.class);
			companyWriter.append(company.getName(), company);
			companyWriter.close();

			// write departments
			SequenceFile.Writer departmentWriter = SequenceFile.createWriter(fs,
					conf, departmentFile, Text.class, Department.class);
			Set<Employee> employeeSet = new HashSet<Employee>();
			for (Department d : depts) {
				departmentWriter.append(d.getName(), d);
			}
			departmentWriter.close();

			// write employees
			SequenceFile.Writer employeeWriter = SequenceFile.createWriter(fs, conf,
					employeeFile, Text.class, Employee.class);
			for (Employee e : empl) {
				employeeWriter.append(e.getName(), e);
			}
			employeeWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	@Test
	public void testSerialization() {
		boolean success = createAndWriteCompany("sampleCompany");
		assertTrue(success);
		if (!success)
			System.err.println("Company could not be serialized successfully");
	}

}