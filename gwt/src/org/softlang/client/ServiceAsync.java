package org.softlang.client;

import org.softlang.client.companyInfo.CompanyInfo;
import org.softlang.client.companyInfo.DeptInfo;
import org.softlang.client.companyInfo.EmployeeInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>Service</code>.
 */
public interface ServiceAsync {

	void getCompanyTotal(AsyncCallback<Double> callback);

	void getDeptTotal(String deptName, AsyncCallback<Double> callback);

	void saveCompanyInfo(String companyName, AsyncCallback<Void> callback);
	
	void saveDeptInfo(String oldDeptName, String deptName,
			AsyncCallback<Void> callback);

	void saveEmployeeInfo(String oldEmployeeName, EmployeeInfo employeeInfo,
			AsyncCallback<Void> callback);

	void getCompanyInfo(AsyncCallback<CompanyInfo> callback);

	void getDeptInfo(String deptName, AsyncCallback<DeptInfo> callback);

	void getEmployeeInfo(String employeeName,
			AsyncCallback<EmployeeInfo> callback);

	void cutCompany(AsyncCallback<Double> callback);

	void cutDept(String deptName, AsyncCallback<Double> callback);

	void cutEmployee(String employeeName, Double salary,
			AsyncCallback<Double> callback);

}
