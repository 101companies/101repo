package org.softlang.client.interfaces;

import org.softlang.client.guiinfos.EmployeeInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmployeeServiceAsync {

	void cut(Integer id, AsyncCallback<Double> callback);

	void saveEmployee(Integer id, String name, String address, double salary,
			Integer parent, AsyncCallback<EmployeeInfo> callback);

	void getEmployee(Integer id, AsyncCallback<EmployeeInfo> callback);

}
