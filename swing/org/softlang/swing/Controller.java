package org.softlang.swing;

import org.softlang.company.*;
import java.util.Stack;

public class Controller {

	private DeptView deptView;
	private EmployeeView employeeView;

	private Company company;
	private Stack<Dept> deptStack = new Stack<Dept>();
	private Dept openDept;
	private Employee openEmployee;

	public Controller(Company company) {
		this.company = company;
	}

	// setters
	public void setEmployeeView(EmployeeView employeeView) {
		this.employeeView = employeeView;
	}

	public void setDeptView(DeptView deptView) {
		this.deptView = deptView;
	}

	//

	public void go() {
		showCompany();
	}

	private void showCompany() {
		deptView.showCompany(company, company.total());
	}

	public void deptClicked(Dept dept) {
		showDept(dept, true);
	}

	private void showDept(Dept dept, boolean deeper) {
		if (openDept != null && deeper)
			deptStack.push(openDept);
		openDept = dept;
		deptView.showDept(dept, dept.total());
	}

	public void saveCompanyClicked(String name) {
		company.setName(name);
	}

	public void saveDeptClicked(String name) {
		openDept.setName(name);
		showDept(openDept, false);
	}

	public void okDeptClicked(String name) {
		openDept.setName(name);
		if (deptStack.isEmpty()) {
			openDept = null;
			deptView.showCompany(company, company.total());
		} else
			showDept(deptStack.pop(), false);
	}

	public void cancelDeptClicked() {
		if (deptStack.isEmpty()) {
			openDept = null;
			deptView.showCompany(company, company.total());
		} else {
			showDept(deptStack.pop(), false);
		}
	}

	public void employeeClicked(Employee employee) {
		showEmployee(employee);
	}

	public void deptOrCompanyClosed() {
		System.exit(0);
	}

	public void employeeClosed() {
		employeeView.setVisibility(false);
		showDept(openDept, false);
		openEmployee = null;
	}

	private void showEmployee(Employee employee) {
		openEmployee = employee;
		employeeView.showEmployee(employee);
	}

	public void saveEmployeeClicked(String name, String address, double salary) {
		if (openEmployee != null) {
			openEmployee.getPerson().setName(name);
			openEmployee.getPerson().setAddress(address);
			openEmployee.setSalary(salary);
		}
		showDept(openDept, false);
		showEmployee(openEmployee);
	}

	public void okEmployeeClicked(String name, String address, double salary) {
		if (openEmployee != null) {
			openEmployee.getPerson().setName(name);
			openEmployee.getPerson().setAddress(address);
			openEmployee.setSalary(salary);
		}
		employeeView.setVisibility(false);
		showDept(openDept, false);
		openEmployee = null;
	}

	public void cancelEmployeeClicked() {
		employeeView.setVisibility(false);
		openEmployee = null;
	}

	public void cutCompanyClicked() {
		company.cut();
		showCompany();
		if (openEmployee != null)
			showEmployee(openEmployee);
	}

	public void cutDeptClicked() {
		openDept.cut();
		showDept(openDept, false);
		if (openEmployee != null)
			showEmployee(openEmployee);
	}

	public void cutEmployeeClicked() {
		openEmployee.cut();
		showEmployee(openEmployee);
		showDept(openDept, false);
	}

}
