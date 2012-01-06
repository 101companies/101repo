package org.softlang.client.interfaces;

import org.softlang.client.guiinfos.CompanyInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CompanyServiceAsync {

	void cut(Integer id, AsyncCallback<Double> callback);

	void getCompany(Integer id, AsyncCallback<CompanyInfo> callback);

	void saveCompany(Integer id, String name, AsyncCallback<String> callback);

}
