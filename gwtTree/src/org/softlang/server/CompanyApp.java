package org.softlang.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.softlang.server.company.Company;
import org.softlang.server.company.Department;
import org.softlang.server.company.Employee;
import org.softlang.shared.ServerValidationException;

public class CompanyApp {
	
	private static CompanyApp singleton;
	
	private Map<Integer, Company> companies;
	private Map<Integer, Department> departments;
	private Map<Integer, Employee> employees;
	
	private CompanyApp() {
		Employee craig = new Employee(1, "Craig", "Redmond", 123456, true);
		Employee ray = new Employee(2, "Ray", "Redmond", 234567, true);
		Employee klaus = new Employee(3, "Klaus", "Boston", 23456, true);
		Employee karl = new Employee(4, "Karl", "Riga", 2345, true);
		Employee erik = new Employee(5, "Erik", "Utrecht", 12345, false);
		Employee ralf = new Employee(6, "Ralf", "Koblenz", 1234, false);
		Employee joe = new Employee(7, "Joe", "Wifi City", 2344, false);
		
		employees = new HashMap<Integer, Employee>();
		employees.put(craig.getId(), craig);
		employees.put(ray.getId(), ray);
		employees.put(klaus.getId(), klaus);
		employees.put(karl.getId(), karl);
		employees.put(erik.getId(), erik);
		employees.put(ralf.getId(), ralf);
		employees.put(joe.getId(), joe);
		
		Department research = new Department(1, "Research");
		Department development = new Department(2, "Development");
		Department dev1 = new Department(3, "Dev 1");
		Department dev11 = new Department(4, "Dev 1.1");
		
		craig.setParent(research);
		erik.setParent(research);
		ralf.setParent(research);
		ray.setParent(development);
		klaus.setParent(dev1);
		karl.setParent(dev11);
		joe.setParent(dev11);
		
		departments = new HashMap<Integer, Department>();
		departments.put(research.getId(), research);
		departments.put(development.getId(), development);
		departments.put(dev1.getId(), dev1);
		departments.put(dev11.getId(), dev11);		
		
		Company company = new Company(1, "Meganalysis");
		
		research.setParent(company);
		development.setParent(company);
		dev1.setParent(development);
		dev11.setParent(dev1);
				
		companies = new HashMap<Integer, Company>();
		companies.put(company.getId(), company);
	}
	
	public static CompanyApp getInstance() {
		if (singleton == null) {
			singleton = new CompanyApp();
		}
		return singleton;
	}

	public Map<Integer, Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Map<Integer, Company> companies) {
		this.companies = companies;
	}

	public Map<Integer, Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Map<Integer, Department> departments) {
		this.departments = departments;
	}

	public Map<Integer, Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Map<Integer, Employee> employees) {
		this.employees = employees;
	}

	private int getNewDepartmentId() {
		Set<Integer> keys = departments.keySet();
		return getNext(keys);
	}
	
	private int getNewEmployeeId() {
		Set<Integer> keys = employees.keySet();
		return getNext(keys);
	}
	
	private int getNext(Set<Integer> list) {
		int max = 0;
		for (Integer item : list) {
			if (max < item) {
				max = item;
			}
		}
		return max + 1;
	}

	public Department createDepartment(String name) {
		int newID = CompanyApp.getInstance().getNewDepartmentId();
		Department department = new Department(newID, name);
		departments.put(newID, department);
		return department;
	}
	
	public Employee createEmployee(String name, String address, Double salary) {
		int newID = CompanyApp.getInstance().getNewEmployeeId();
		Employee employee = new Employee(newID, name, address, salary, false);
		employees.put(newID, employee);
		return employee;
	}

	public String validateSalary(int id) {
		Employee employee = employees.get(id);
		if (employee.isManager()) {
			Department parent = employee.getParent();
			Double max = getMaximumSalary(parent);
			if (max > employee.getSalary()) {
				return "Salary too low.";
			}
		}
		return null;
	}
	
	public Double getMaximumSalary(Department dep) {
		Double max = 0d;
		for (Employee emp : dep.getEmployees()) {
			if (emp.getSalary() > max) {
				max = emp.getSalary();
			}
		}
		for (Department sub : dep.getDepartments()) {
			Double subMax = getMaximumSalary(sub);
			if (subMax > max) {
				max = subMax;
			}
		}
		return max;
	}

	public void validateCompany(Integer id, String name) throws ServerValidationException {
		for (Company company : companies.values()) {
			if (company.getName().equals(name) && (id == null || company.getId() != id.intValue())) {
				throw new ServerValidationException(ServerValidationException.Field.NAME,
						"There is already a company named " + name + "!");
			}
		}
	}

	public void validateDepartment(Integer id, String name) throws ServerValidationException {
		for (Department department : departments.values()) {
			if (department.getName().equals(name) && (id == null || department.getId() != id.intValue())) {
				throw new ServerValidationException(ServerValidationException.Field.NAME,
						"There is already a department named " + name + "!");
			}
		}
	}

	public void validateEmployee(Integer id, String name, double salary, Integer parent) throws ServerValidationException {
		System.out.println(parent);
		System.out.println(departments.keySet());
		Department parentDepartment = departments.get(parent);
		if (parentDepartment.getManager() != null && parentDepartment.getManager().getSalary() < salary && parentDepartment.getManager().getId() != id) {
			throw new ServerValidationException(ServerValidationException.Field.SALARY,
					"The salary must not be greater than " + parentDepartment.getManager().getSalary() + "!");
		}
		for (Employee employee : employees.values()) {
			if (employee.getName().equals(name) && (id == null || employee.getId() != id.intValue())) {
				throw new ServerValidationException(ServerValidationException.Field.NAME,
						"There is already an employee named " + name + "!");
			}
		}
	}

	public void deleteDepartment(Integer id) {
		Department department = departments.get(id);
		deleteDepartmentSubs(id);
		department.getParent().getDepartments().remove(department);
	}
	
	public void deleteDepartmentSubs(Integer id) {
		Department department = departments.get(id);
		
		for (Department sub : department.getDepartments()) {
			deleteDepartmentSubs(sub.getId());
		}
		department.getDepartments().clear();
		for (Employee emp : department.getEmployees()) {
			employees.remove(emp.getId());
		}
		department.getEmployees().clear();
		
		departments.remove(id);
	}

	public void deleteEmployee(int id) {
		Employee employee = employees.get(id);
		employee.getParent().getEmployees().remove(employee);
		employees.remove(id);
	}
}
