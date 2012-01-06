package org.softlang.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtTree implements EntryPoint {

	
	private TreePanel treePanel;
	private ScrollPanel contentPanel;
	
	private CompanyPanel companyPanel;
	private DepartmentPanel departmentPanel;
	private EmployeePanel employeePanel;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		SplitLayoutPanel mainPanel = new SplitLayoutPanel();
		
		
		
		mainPanel.setStylePrimaryName("main");
		
		treePanel = new TreePanel(this);
		contentPanel = new ScrollPanel();
		
		companyPanel = new CompanyPanel(treePanel);
		departmentPanel = new DepartmentPanel(treePanel);
		employeePanel = new EmployeePanel(treePanel);
		
		treePanel.refreshTree();
		
		ScrollPanel treeScroll = new ScrollPanel(treePanel);
		treeScroll.setStylePrimaryName("tree");
		
		mainPanel.addSouth(new ButtonPanel(this), 32);
		mainPanel.addWest(treeScroll, 350);
		mainPanel.add(contentPanel);
		
		RootPanel.get("content").add(mainPanel);
	}

	public void showCompany(Integer companyId) {
		contentPanel.clear();
		companyPanel.setCompany(companyId);
		contentPanel.add(companyPanel);
	}

	public void showDepartment(Integer departmentId) {
		contentPanel.clear();
		departmentPanel.setDepartment(departmentId);
		contentPanel.add(departmentPanel);
	}

	public void showEmployee(Integer employeeId) {
		contentPanel.clear();
		employeePanel.setEmployee(employeeId);
		contentPanel.add(employeePanel);
	}
}
