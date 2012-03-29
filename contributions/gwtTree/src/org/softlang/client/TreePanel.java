package org.softlang.client;

import java.util.Collections;
import java.util.List;

import org.softlang.client.guiinfos.TreeInfo;
import org.softlang.client.guiinfos.tree.CompanyItem;
import org.softlang.client.guiinfos.tree.DepartmentItem;
import org.softlang.client.guiinfos.tree.EmployeeItem;
import org.softlang.client.guiinfos.tree.comparators.DepComparator;
import org.softlang.client.guiinfos.tree.comparators.EmpComparator;
import org.softlang.client.interfaces.TreeService;
import org.softlang.client.interfaces.TreeServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class TreePanel extends Tree {
	
	private GwtTree main;
	
	private final TreeServiceAsync treeService = GWT.create(TreeService.class);
	
	public TreePanel(GwtTree main) {
		this.main = main;
		
		this.addSelectionHandler(new SelectionHandler<TreeItem>() {
			
			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
				Object obj = event.getSelectedItem().getUserObject();
				if (obj instanceof CompanyItem) {
					TreePanel.this.main.showCompany(((CompanyItem)obj).getId());
				} else if (obj instanceof DepartmentItem) {
					TreePanel.this.main.showDepartment(((DepartmentItem)obj).getId());
				} else if (obj instanceof EmployeeItem) {
					TreePanel.this.main.showEmployee(((EmployeeItem)obj).getId());
				}
			}
		});
	}
	
	public void refreshTree() {
		treeService.getTree(new AsyncCallback<TreeInfo>() {
			
			@Override
			public void onSuccess(TreeInfo result) {
				generateTree(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	}
	
	private void generateTree(TreeInfo info) {
		clear();
		for (CompanyItem item : info.getCompanies()) {
			TreeItem root = new TreeItem(item.getName());
			root.setUserObject(item);
			appendDepsAndEmps(root, item.getDepartments());
			addItem(root);
		}
	}

	private void appendDepsAndEmps(TreeItem root, List<DepartmentItem> departments) {
		Collections.sort(departments, new DepComparator());
		
		for (DepartmentItem dItem : departments) {
			TreeItem treeDItem = new TreeItem();
			if (dItem.isFault()) {
				treeDItem = new TreeItem(dItem.getName() + " - " + dItem.getFaultMessage());
				treeDItem.setStylePrimaryName("error");
			} else {
				treeDItem = new TreeItem(dItem.getName());
				treeDItem.setStylePrimaryName("normal");
			}
			treeDItem.setUserObject(dItem);
			root.addItem(treeDItem);
			
			List<EmployeeItem> empItems = dItem.getEmployees();
			Collections.sort(empItems, new EmpComparator());
			for (EmployeeItem eItem : empItems) {
				String name = eItem.getName();
				if (eItem.isManager()) {
					name += " (Manager)";
				}
				TreeItem treeEItem;
				if (eItem.isFault()) {
					treeEItem = new TreeItem(name + " - " + eItem.getFaultMessage());
					treeEItem.setStylePrimaryName("error");
				} else {
					treeEItem = new TreeItem(name);
					treeEItem.setStylePrimaryName("normal");
				}
				treeEItem.setUserObject(eItem);
				treeDItem.addItem(treeEItem);
			}
			appendDepsAndEmps(treeDItem, dItem.getDepartments());
		}
	}
}
