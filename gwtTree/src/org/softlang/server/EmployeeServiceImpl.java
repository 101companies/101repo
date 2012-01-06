package org.softlang.server;

import java.util.HashMap;
import java.util.Map;

import org.softlang.client.guiinfos.EmployeeInfo;
import org.softlang.client.interfaces.EmployeeService;
import org.softlang.server.company.Employee;
import org.softlang.shared.ServerValidationException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EmployeeServiceImpl extends RemoteServiceServlet implements EmployeeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2006611102432366389L;

	@Override
	public double cut(Integer id) {
		Employee employee = CompanyApp.getInstance().getEmployees().get(id);
				
		employee.cut();
		
		return employee.getSalary();
	}

	@Override
	public EmployeeInfo getEmployee(Integer id) {
		EmployeeInfo result = new EmployeeInfo();
		
		if (id != null) {
			Employee employee = CompanyApp.getInstance().getEmployees().get(id);
			result.setName(employee.getName());
			result.setAddress(employee.getAddress());
			result.setTotal(employee.getSalary());
			
			result.setParent(employee.getParent().getId());
			result.setId(employee.getId());
		}
		
		Map<Integer, String> allDeps = new HashMap<Integer, String>();
		for (Integer key : CompanyApp.getInstance().getDepartments().keySet()) {
			allDeps.put(key, CompanyApp.getInstance().getDepartments().get(key).getName());
		}
		result.setAllDepartments(allDeps);
		
		return result;
	}

	@Override
	public EmployeeInfo saveEmployee(Integer id, String name, String address,
			double salary, Integer parent) throws ServerValidationException {

		CompanyApp.getInstance().validateEmployee(id, name, salary, parent);
		
		Employee employee;
		if (id != null) {
			employee = CompanyApp.getInstance().getEmployees().get(id);
			employee.setName(name);
			employee.setAddress(address);
			employee.setSalary(salary);
		} else {
			employee = CompanyApp.getInstance().createEmployee(name, address, salary);
		}
		
		if (employee.getParent() != null) {
			if (employee.getParent().getId() != parent) {
				employee.setParent(CompanyApp.getInstance().getDepartments().get(parent));
				employee.setManager(false);
			}
		} else {
			employee.setParent(CompanyApp.getInstance().getDepartments().get(parent));
			employee.setManager(false);
		}

		id = employee.getId();
		return getEmployee(id);
	}

}
