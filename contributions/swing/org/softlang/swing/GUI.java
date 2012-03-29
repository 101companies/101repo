package org.softlang.swing;

import org.softlang.company.Company;

public class GUI {

	public GUI (Company c) {
		Controller controller = new Controller(c);
		DeptView deptView = new DeptView(controller);
		EmployeeView employeeView = new EmployeeView(controller);
		controller.setDeptView(deptView);
		controller.setEmployeeView(employeeView);
		controller.go();
	}
}