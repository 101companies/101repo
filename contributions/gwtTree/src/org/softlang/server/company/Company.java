package org.softlang.server.company;

import java.util.ArrayList;
import java.util.List;

public class Company implements Parent {
	
	private int id;
	private String name;
	private List<Department> departments;
	
	public Company(int id, String name) {
		this.id = id;
		this.name = name;
		this.departments = new ArrayList<Department>();
	}
	
	public Company(int id, String name, List<Department> departments) {
		this.id = id;
		this.name = name;
		this.departments = departments;
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
			department.setParent(null);
		}
	}
	
	public int getId() {
		return id;
	}
	
	public double total() {
		double total = 0;
		
		for (Department department : departments) {
			total += department.total();
		}
		
		return total;
	}
	
	public void cut() {
		for (Department department : departments) {
			department.cut();
		}
	}
	
}
