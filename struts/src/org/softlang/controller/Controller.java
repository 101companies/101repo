package org.softlang.controller;

import java.util.List;

import org.softlang.model.*;

public class Controller implements org.softlang.controller.Operation {

	private static Company company;
	private Dept department;
	private Employee employee;

	static {
		setCompany(new Demo().createCompany());
	}

	@Override
	public Dept searchDept(String name) {
		for (Dept d : getCompany().getDepts()) {
			if (d.getName().equals(name)) {
				return d;
			}
			searchDept(d, name);
		}
		return department;
	}

	private void searchDept(Dept d, String name) {
		if (d.getName().equals(name)) {
			setDepartment(d);
		} else {
			for (Subunit sub : d.getSubunits()) {
				if (sub.getDu() != null) {
					searchDept(sub.getDu(), name);
				}
			}
		}
	}

	@Override
	public Employee searchEmployee(String name) {
		for (Dept d : getCompany().getDepts()) {
			if (d.getManager().getPerson().getName().equals(name)) {
				return d.getManager();
			}
			searchEmployee(d, name);
		}
		return employee;
	}

	private void searchEmployee(Dept d, String name) {
		if (d.getManager().getPerson().getName().equals(name)) {
			setEmployee(d.getManager());
		} else {
			for (Subunit sub : d.getSubunits()) {
				if (sub.getPu() != null) {
					if (sub.getPu().getPerson().getName().equals(name)) {
						setEmployee(sub.getPu()); break;
					}
				} else {
					searchEmployee(sub.getDu(), name);
				}
			}
		}
	}

	@Override
	public void updateDept(String deptName, Dept upDept) {
		List<Dept> list = getCompany().getDepts();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(deptName)) {
				upDept.setSubunits(list.get(i).getSubunits());
				list.set(i, upDept);
				break;
			}
			updateDept(list.get(i), deptName, upDept);
		}
	}

	public void updateDept(Dept curr, String deptName, Dept upDept) {
		for (Subunit sub : curr.getSubunits()) {
			if (sub.getDu() != null) {
				if (sub.getDu().getName().equals(deptName)) {
					upDept.setSubunits(sub.getDu().getSubunits());
					sub.setDu(upDept);
					break;
				} else {
					updateDept(sub.getDu(), deptName, upDept);
				}
			}
		}
	}

	@Override
	public void updateEmployee(String empName, Employee upEmpl) {
		for (Dept d : getCompany().getDepts()) {
			if (d.getManager().getPerson().getName().equals(empName)) {
				d.setManager(upEmpl);
				break;
			}
			updateEmployee(d, empName, upEmpl);
		}
	}

	public void updateEmployee(Dept curr, String empName, Employee upEmpl) {
		if (curr.getManager().getPerson().getName().equals(empName)) {
			curr.setManager(upEmpl);
		} else {
			for (Subunit sub : curr.getSubunits()) {
				if (sub.getPu() != null) {
					if (sub.getPu().getPerson().getName().equals(empName)) {
						sub.setPu(upEmpl); break;
					}
				} else {
					updateEmployee(sub.getDu(), empName, upEmpl);
				}
			}
		}
	}

	public static void setCompany(Company company) {
		Controller.company = company;
	}

	public Company getCompany() {
		return company;
	}

	public void setDepartment(Dept department) {
		this.department = department;
	}

	public Dept getDepartment() {
		return department;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

}
