package org.softlang.tests;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

/**
 * This class is used to create adequate sized test companies to see the boost
 * of multithreading.
 * 
 */
public class CompanyCreator {

	final static int DEPTH = 5;
	final static int WIDTH = 5;

	final static double MANAGER_SALARY = 100;
	final static double EMPLOYEE_SALARY = 10;

	public static final double SALARY_PER_DEP = WIDTH * EMPLOYEE_SALARY
			+ MANAGER_SALARY;

	public static final double SALARY = SALARY_PER_DEP * WIDTH
			* (WIDTH * Math.pow(WIDTH, DEPTH) - 1) / (WIDTH - 1);

	/**
	 * Create a company
	 * 
	 * @return a company with many departments and many many sub departments
	 */
	public static Company createCompany() {
		// Create company
		Company company = new Company();
		company.setName("meganalysis");

		for (int i = 1; i <= WIDTH; i++) {
			Department dep = new Department();
			company.getDepts().add(dep);

			dep.setName("Dep. " + DEPTH + "." + i);
			addManagerAndFillWithEmployees(dep, WIDTH);
			addManySubDeps(dep, WIDTH, DEPTH - 1);
		}

		return company;
	}

	/**
	 * Add *recursively* new sub departments till depth is equal to zero.
	 * 
	 * @param dep
	 *            the department which should receive new sub departments
	 * @param width
	 *            the number of sub departments and employees
	 * @param depth
	 *            the depth we fill in our company "tree"
	 */
	public static void addManySubDeps(Department dep, int width, int depth) {
		for (int i = 1; i <= width; i++) {
			Department newDep = new Department();
			dep.getSubdepts().add(newDep);

			newDep.setName("Dep. " + depth + "." + i);
			addManagerAndFillWithEmployees(newDep, width);

			if (depth > 0) {
				addManySubDeps(newDep, width, depth - 1);
			}
		}
	}

	/**
	 * Add a number of employees to a department.
	 * 
	 * @param dep
	 *            the department which should receive new employees
	 * @param number
	 *            the number of employees (+1 manager)
	 */
	public static void addManagerAndFillWithEmployees(Department dep, int number) {
		Employee manager = new Employee();
		manager.setName("Manager of " + dep.getName());
		manager.setSalary(MANAGER_SALARY);
		dep.setManager(manager);

		for (int j = 1; j <= number; j++) {
			Employee employee = new Employee();
			employee.setName("Employee#" + j + " of " + dep.getName());
			employee.setSalary(EMPLOYEE_SALARY);
			dep.getEmployees().add(employee);
		}
	}

}
