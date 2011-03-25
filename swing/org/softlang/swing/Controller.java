package org.softlang.swing;

import org.softlang.company.*;
import static org.softlang.operations.Total.*;
import static org.softlang.operations.Cut.*;
import java.util.Stack;

public class Controller {

	private DeptView deptView;
	private EmployeeView employeeView;

	private Company company;
	private Stack<Department> deptStack = new Stack<Department>();
	private Department openDept;
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
		deptView.showCompany(company, total(company));
	}

	public void deptClicked(Department dept) {
		showDept(dept, true);
	}

	private void showDept(Department dept, boolean deeper) {
		if (openDept != null && deeper)
			deptStack.push(openDept);
		openDept = dept;
		deptView.showDept(dept, total(dept));
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
			deptView.showCompany(company, total(company));
		} else
			showDept(deptStack.pop(), false);
	}

	public void cancelDeptClicked() {
		if (deptStack.isEmpty()) {
			openDept = null;
			deptView.showCompany(company, total(company));
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
			openEmployee.setName(name);
			openEmployee.setAddress(address);
			openEmployee.setSalary(salary);
		}
		showDept(openDept, false);
		showEmployee(openEmployee);
	}

	public void okEmployeeClicked(String name, String address, double salary) {
		if (openEmployee != null) {
			openEmployee.setName(name);
			openEmployee.setAddress(address);
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
		cut(company);
		showCompany();
		if (openEmployee != null)
			showEmployee(openEmployee);
	}

	public void cutDeptClicked() {
		cut(openDept);
		showDept(openDept, false);
		if (openEmployee != null)
			showEmployee(openEmployee);
	}

	public void cutEmployeeClicked() {
		cut(openEmployee);
		showEmployee(openEmployee);
		showDept(openDept, false);
	}

}
