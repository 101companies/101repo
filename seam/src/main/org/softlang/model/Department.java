package org.softlang.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_101_DEPARTMENT")
public class Department implements Subunit {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	@ManyToOne(optional=true)
	private Company company;

	@ManyToOne(optional=true)
	private Employee manager;
	
	@ManyToOne(optional = true)
	private Department parent;
	
	@OneToMany(mappedBy="parent")
	private List<Department> departments;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employees;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public void cut() {
		manager.cut();
		
		for(Employee emp : employees) {
			emp.cut();
		}
		
		for(Department dept : departments) {
			dept.cut();
		}
	}

	@Override
	public double total() {
		double total = manager.total();
		
		for (Employee emp : employees) {
			total += emp.total();
		}
		for (Department dept : departments) {
			total += dept.total();
		}
		return total;
	}
	
	public boolean hasSubDepartments() {
		return departments.size() > 0;
	}
	
	public boolean hasEmployees() {
		return employees.size() > 0;
	}

}
