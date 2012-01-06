package org.softlang.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.softlang.client.guiinfos.TreeInfo;
import org.softlang.client.guiinfos.tree.CompanyItem;
import org.softlang.client.guiinfos.tree.DepartmentItem;
import org.softlang.client.guiinfos.tree.EmployeeItem;
import org.softlang.client.interfaces.TreeService;
import org.softlang.server.company.Company;
import org.softlang.server.company.Department;
import org.softlang.server.company.Employee;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TreeServiceImpl extends RemoteServiceServlet implements TreeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1626179990776929469L;
	
	@Override
	public TreeInfo getTree() {
		List<CompanyItem> companyItems = new ArrayList<CompanyItem>();
		
		Map<Integer, Company> companies = CompanyApp.getInstance().getCompanies();
		
		for (Integer key : companies.keySet()) {
			Company company = companies.get(key);
			CompanyItem cItem = new CompanyItem();
			cItem.setId(company.getId());
			cItem.setName(company.getName());
			
			List<DepartmentItem> cDeps = new ArrayList<DepartmentItem>();
			
			for (Department department : company.getDepartments()) {				
				DepartmentItem dItem = new DepartmentItem();
				dItem.setId(department.getId());
				dItem.setName(department.getName());
				dItem.setDepartments(generateDeps(department));
				dItem.setEmployees(generateEmps(department));
				
				if (department.getManager() == null) {
					dItem.setFaultMessage("No manager");
				}
				
				cDeps.add(dItem);
			}
			cItem.setDepartments(cDeps);
			companyItems.add(cItem);
		}
		
		TreeInfo info = new TreeInfo();
		info.setCompanies(companyItems);
		
		return info;
	}
	
	private List<EmployeeItem> generateEmps(Department current) {
		List<EmployeeItem> dEmps = new ArrayList<EmployeeItem>();
		for (Employee employee : current.getEmployees()) {
			
			Double maximumSalary = CompanyApp.getInstance().getMaximumSalary(employee.getParent());
			
			EmployeeItem eItem = new EmployeeItem();
			eItem.setId(employee.getId());
			eItem.setName(employee.getName());
			eItem.setManager(employee.isManager());
			
			if (employee.isManager() && maximumSalary > employee.getSalary()) {
				eItem.setFaultMessage("Salary too low");
			}
			
			dEmps.add(eItem);
		}
		return dEmps;
	}

	private List<DepartmentItem> generateDeps(Department current) {
		List<DepartmentItem> result = new ArrayList<DepartmentItem>();
		for (Department department : current.getDepartments()) {
			DepartmentItem dItem = new DepartmentItem();
			dItem.setId(department.getId());
			dItem.setName(department.getName());
			dItem.setDepartments(generateDeps(department));
			dItem.setEmployees(generateEmps(department));
			result.add(dItem);
		}
		return result;
	}

}
