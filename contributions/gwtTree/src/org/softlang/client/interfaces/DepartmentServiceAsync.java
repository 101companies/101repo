package org.softlang.client.interfaces;

import org.softlang.client.guiinfos.DepartmentInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DepartmentServiceAsync {

	void cut(Integer id, AsyncCallback<Double> callback);

	void getDepartment(Integer id, AsyncCallback<DepartmentInfo> callback);

	void saveDepartment(Integer id, String name, Integer parent, Integer manager,
			AsyncCallback<DepartmentInfo> callback);

	void delete(Integer department, AsyncCallback<Boolean> asyncCallback);
}
