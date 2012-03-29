package org.softlang.client;

import org.softlang.client.companyInfo.*;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface Service extends RemoteService {
	CompanyInfo getCompanyInfo();

	DeptInfo getDeptInfo(String deptName);

	EmployeeInfo getEmployeeInfo(String employeeName);

	void saveCompanyInfo(String companyName);
	
	void saveDeptInfo(String oldDeptName, String deptName);

	void saveEmployeeInfo(String oldEmployeeName, EmployeeInfo employeeInfo);

	// Total
	Double getCompanyTotal();

	Double getDeptTotal(String deptName);

	// Cut
	Double cutCompany();

	Double cutDept(String deptName);

	Double cutEmployee(String employeeName, Double salary);

}
