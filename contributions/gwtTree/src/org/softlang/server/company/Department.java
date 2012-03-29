package org.softlang.server.company;

import java.util.ArrayList;
import java.util.List;

public class Department implements Parent {
	
	private int id;
	private String name;
	private List<Department> departments;
	private List<Employee> employees;
	private Parent parent;
	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
		this.departments = new ArrayList<Department>();
		this.employees = new ArrayList<Employee>();
	}
	
	public Department(int id, String name, List<Department> departments, List<Employee> employees) {
		this.id = id;
		this.name = name;
		setDepartments(departments);
		setEmployees(employees);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Department> getDepartments() {
		return departments;
	}
	
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
		for (Department department : this.departments) {
			department.setParent(this);
		}
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
		for (Employee employee : this.employees) {
			employee.setParent(this);
		}
	}
	
	public int getId() {
		return id;
	}
	
	public double total() {
		double total = 0;
		
		for (Employee employee : employees) {
			total += employee.getSalary();
		}
		for (Department department : departments) {
			total += department.total();
		}
		
		return total;
	}
	
	public void cut() {
		for (Employee employee : employees) {
			employee.cut();
		}
		for (Department department : departments) {
			department.cut();
		}
	}

	public void setParent(Parent parent) {
		if (this.parent != null) {
			this.parent.getDepartments().remove(this);
		}
		this.parent = parent;
		if (this.parent != null) {
			this.parent.getDepartments().add(this);
		}
	}
	
	public Parent getParent() {
		return this.parent;
	}

	public Employee getManager() {
		Employee result = null;
		for (Employee emp : this.employees) {
			if (emp.isManager()) {
				result = emp;
			}
		}
		return result;
	}

	public void setManager(Employee employee) {
		if (employee != null) {
			Employee ex = getManager();
			if (ex != null) {
				ex.setManager(false);
			}
			employee.setParent(this);
			employee.setManager(true);
		}
	}
	
}
