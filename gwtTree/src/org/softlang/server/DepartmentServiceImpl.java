package org.softlang.server;

import java.util.HashMap;
import java.util.Map;

import org.softlang.client.guiinfos.DepartmentInfo;
import org.softlang.client.interfaces.DepartmentService;
import org.softlang.server.company.Department;
import org.softlang.shared.ServerValidationException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DepartmentServiceImpl extends RemoteServiceServlet implements DepartmentService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 864523380679574211L;

	@Override
	public double cut(Integer id) {
		Department department = CompanyApp.getInstance().getDepartments().get(id);
		
		department.cut();
		
		return department.total();
	}

	@Override
	public DepartmentInfo getDepartment(Integer id) {
		DepartmentInfo result = new DepartmentInfo();
		
		if (id != null) {
			
			Department department = CompanyApp.getInstance().getDepartments().get(id);
			
			result.setName(department.getName());
			result.setTotal(department.total());
			
			Map<Integer, String> otherDeps = new HashMap<Integer, String>();
			for (Integer key : CompanyApp.getInstance().getDepartments()
					.keySet()) {
				if (key != department.getId()) {
					otherDeps.put(key, CompanyApp.getInstance()
							.getDepartments().get(key).getName());
				}
			}
			
			result.setOtherDepartments(otherDeps);
			
			if (department.getParent() instanceof Department) {
				result.setParentDepartment(department.getParent().getId());
			} else {
				result.setParentDepartment(null);
			}
			
			if (department.getManager() != null) {
				result.setManager(department.getManager().getId());
			} else {
				result.setManager(null);
			}
			result.setId(department.getId());
		} else {
			
			Map<Integer, String> otherDeps = new HashMap<Integer, String>();
			for (Integer key : CompanyApp.getInstance().getDepartments()
					.keySet()) {
					otherDeps.put(key, CompanyApp.getInstance()
							.getDepartments().get(key).getName());
			}
			result.setOtherDepartments(otherDeps);
		}
		
		Map<Integer, String> emps = new HashMap<Integer, String>();
		for (Integer key : CompanyApp.getInstance().getEmployees().keySet()) {
			emps.put(key, CompanyApp.getInstance().getEmployees().get(key).getName());
		}
		result.setAllEmployees(emps);
		
		return result;
	}

	@Override
	public DepartmentInfo saveDepartment(Integer id, String name, Integer parent,
			Integer manager) throws ServerValidationException {
		
		CompanyApp.getInstance().validateDepartment(id, name);
		
		Department department;
		if (id != null) {
			department = CompanyApp.getInstance().getDepartments().get(id);
			department.setName(name);
		} else {
			department = CompanyApp.getInstance().createDepartment(name);
		}
		
		if (parent != null) {
			department.setParent(CompanyApp.getInstance().getDepartments().get(parent));
		} else {
			department.setParent(CompanyApp.getInstance().getCompanies().get(1));
		}
		
		if (manager != null) {
			department.setManager(CompanyApp.getInstance().getEmployees().get(manager));
		} else {
			department.setManager(null);
		}
		
		id = department.getId();
		return getDepartment(id);
	}

	@Override
	public boolean delete(Integer id) {
		CompanyApp.getInstance().deleteDepartment(id);		
		return true;
	}

}
