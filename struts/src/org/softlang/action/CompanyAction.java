package org.softlang.action;

import java.util.List;
import org.softlang.model.Company;
import org.softlang.model.Dept;
import org.softlang.model.Employee;
import org.softlang.service.Service;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class CompanyAction extends ActionSupport implements Preparable,
		org.softlang.action.Operation {

	private static final long serialVersionUID = 1L;
	private Service service = new Service();
	private List<Dept> depts;
	private Company company;
	private Dept department;
	private Employee employee;
	private String empName;
	private String deptName;
	
	@Override
	public void prepare() throws Exception {
		if (department != null && department.getName() != null) {
			setDepartment(service.searchDept(department.getName()));
		}

		if (employee != null && employee.getPerson().getName() != null) {
			setEmployee(service.searchEmployee(employee.getPerson().getName()));
		}
	}

	@Override
	public String doInit() {
		setCompany(service.getController().getCompany());
		setDepts(service.getController().getCompany().getDepts());
		return SUCCESS;
	}

	@Override
	public String doInput() {
		return INPUT;
	}

	@Override
	public String doSave() {
		if (department != null && deptName != null) {
			service.updateDept(deptName, department);
		}
		if (employee != null && empName != null) {
			service.updateEmployee(empName, employee);
		}
		setDepts(service.getController().getCompany().getDepts());
		
		return SUCCESS;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	public List<Dept> getDepts() {
		return depts;
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

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptName() {
		return deptName;
	}

}
