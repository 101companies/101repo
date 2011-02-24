package org.softlang.server;

import java.util.HashMap;

import org.softlang.client.*;
import org.softlang.client.companyInfo.*;
import org.softlang.server.company.*;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ServiceImpl extends RemoteServiceServlet implements Service {

	private Company company;

	private HashMap<String, Dept> deptMap;

	private HashMap<String, Employee> employeeMap;

	public ServiceImpl() {
		this.company = SampleCompany.getSampleCompany();
		Index companyFlater = new Index();
		companyFlater.index(company);
		this.deptMap = companyFlater.getDeptMap();
		this.employeeMap = companyFlater.getEmployeeMap();
	}

	@Override
	public CompanyInfo getCompanyInfo() {
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setName(company.getName());
		for (Dept dept : company.getDepts())
			companyInfo.getDeptsInfos().add(dept.getName());
		return companyInfo;
	}

	@Override
	public DeptInfo getDeptInfo(String deptName) {
		DeptInfo deptInfo = new DeptInfo();
		Dept dept = deptMap.get(deptName);
		if (dept != null) {
			deptInfo.setName(dept.getName());
			deptInfo.setManagerInfo(dept.getManager().getPerson().getName());
			for (Subunit subunit : dept.getSubunits()) {
				if (subunit.getPu() != null) {
					SubunitInfo subunitInfo = new SubunitInfo();
					subunitInfo
							.setPuInfo(subunit.getPu().getPerson().getName());
					deptInfo.getSubunitsInfos().add(subunitInfo);
				} else {
					SubunitInfo subunitInfo = new SubunitInfo();
					subunitInfo.setDuInfo(subunit.getDu().getName());
					deptInfo.getSubunitsInfos().add(subunitInfo);
				}
			}
		}
		return deptInfo;
	}

	@Override
	public EmployeeInfo getEmployeeInfo(String employeeName) {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		Employee employee = employeeMap.get(employeeName);
		if (employee != null) {
			employeeInfo.setName(employee.getPerson().getName());
			employeeInfo.setAddress(employee.getPerson().getAddress());
			employeeInfo.setSalary(employee.getSalary());
		}
		return employeeInfo;
	}

	@Override
	public void saveCompanyInfo(String companyName) {
		company.setName(companyName);

	}

	@Override
	public void saveDeptInfo(String oldDeptName, String deptName) {
		Dept dept = deptMap.get(oldDeptName);
		if (dept != null) {
			dept.setName(deptName);
			deptMap.remove(deptName);
			deptMap.put(deptName, dept);
		}

	}

	@Override
	public void saveEmployeeInfo(String oldEmployeeName,
			EmployeeInfo employeeInfo) {
		Employee employee = employeeMap.get(oldEmployeeName);
		if (employee != null) {
			employee.getPerson().setName(employeeInfo.getName());
			employee.getPerson().setAddress(employeeInfo.getAddress());
			employee.setSalary(employeeInfo.getSalary());
			employeeMap.remove(employeeInfo.getName());
			employeeMap.put(employeeInfo.getName(), employee);
		}

	}

	@Override
	public Double getCompanyTotal() {
		return company.total();
	}

	@Override
	public Double getDeptTotal(String deptName) {
		Dept dept = deptMap.get(deptName);
		if (dept != null)
			return dept.total();
		return null;
	}

	@Override
	public Double cutCompany() {
		company.cut();
		return company.total();
	}

	@Override
	public Double cutDept(String deptName) {
		Dept dept = deptMap.get(deptName);
		if (dept != null) {
			dept.cut();
			return dept.total();
		}
		return null;
	}

	@Override
	public Double cutEmployee(String employeeName, Double salary) {
		Employee employee = employeeMap.get(employeeName);
		if (employee != null) {
			employee.setSalary(salary);
			employee.cut();
			return new Double(employee.total());
		}
		return null;
	}

}
