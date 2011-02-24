package org.softlang.service;

import org.softlang.controller.Controller;
import org.softlang.model.Dept;
import org.softlang.model.Employee;

public class Service implements org.softlang.controller.Operation {

	private Controller controller;

	public Service() {
		setController(new Controller());
	}

	@Override
	public Dept searchDept(String name) {
		return getController().searchDept(name);
	}

	@Override
	public Employee searchEmployee(String name) {
		return getController().searchEmployee(name);
	}

	@Override
	public void updateDept(String deptName, Dept d) {
		getController().updateDept(deptName, d);
	}

	@Override
	public void updateEmployee(String empName, Employee e) {
		getController().updateEmployee(empName, e);
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public Controller getController() {
		return controller;
	}

}
