package org.softlang.client.companyInfo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class DeptInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3761548338092052046L;

	private String name;
	private String managerInfo;
	private List<SubunitInfo> subunitsInfos;

	public DeptInfo(){
		name = "";
		managerInfo = "";
		subunitsInfos = new LinkedList<SubunitInfo>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagerInfo() {
		return managerInfo;
	}

	public void setManagerInfo(String managerInfo) {
		this.managerInfo = managerInfo;
	}

	public List<SubunitInfo> getSubunitsInfos() {
		return subunitsInfos;
	}

}
