package org.softlang.client.interfaces;

import org.softlang.client.guiinfos.EmployeeInfo;
import org.softlang.shared.ServerValidationException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("employee")
public interface EmployeeService extends RemoteService {

	public double cut(Integer id);
	
	public EmployeeInfo getEmployee(Integer id);
	
	public EmployeeInfo saveEmployee(Integer id, String name, String address, double salary, Integer parent) throws ServerValidationException;

	boolean delete(Integer employee);
}
