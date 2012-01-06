package org.softlang.client.interfaces;

import org.softlang.client.guiinfos.DepartmentInfo;
import org.softlang.shared.ServerValidationException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("department")
public interface DepartmentService extends RemoteService {

	public double cut(Integer id);
	
	public DepartmentInfo getDepartment(Integer id);
	
	public DepartmentInfo saveDepartment(Integer id, String name, Integer parent, Integer manager) throws ServerValidationException;
	
}
