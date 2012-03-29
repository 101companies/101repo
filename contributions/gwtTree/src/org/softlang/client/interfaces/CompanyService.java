package org.softlang.client.interfaces;

import org.softlang.client.guiinfos.CompanyInfo;
import org.softlang.shared.ServerValidationException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("company")
public interface CompanyService extends RemoteService {
	
	public double cut(Integer id);
	
	public CompanyInfo getCompany(Integer id);
	
	public String saveCompany(Integer id, String name) throws ServerValidationException;
}
