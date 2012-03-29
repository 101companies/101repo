package org.softlang.client.companyInfo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CompanyInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7643671446390318654L;

	private String name;
	private List<String> deptsInfos;

	public CompanyInfo() {
		deptsInfos = new LinkedList<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDeptsInfos() {
		return deptsInfos;
	}

}
