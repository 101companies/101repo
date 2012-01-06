package org.softlang.client.guiinfos;

import java.io.Serializable;
import java.util.List;

import org.softlang.client.guiinfos.tree.CompanyItem;

public class TreeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7501004858761818375L;
	
	private List<CompanyItem> companies;
	
	public void setCompanies(List<CompanyItem> companies) {
		this.companies = companies;
	}

	public List<CompanyItem> getCompanies() {
		return companies;
	}
}
