package org.softlang.client.companyInfo;

import java.io.Serializable;

public class SubunitInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4996369755998025141L;
	private String puInfo;
	private String duInfo;

	public String getPuInfo() {
		return puInfo;
	}

	public void setPuInfo(String puInfo) {
		this.puInfo = puInfo;
	}

	public String getDuInfo() {
		return duInfo;
	}

	public void setDuInfo(String duInfo) {
		this.duInfo = duInfo;
	}

}
