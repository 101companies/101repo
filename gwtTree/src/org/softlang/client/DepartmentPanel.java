package org.softlang.client;

import org.softlang.client.guiinfos.DepartmentInfo;
import org.softlang.client.interfaces.DepartmentService;
import org.softlang.client.interfaces.DepartmentServiceAsync;
import org.softlang.shared.ServerValidationException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DepartmentPanel extends VerticalPanel {
	
	private final DepartmentServiceAsync  departmentService = GWT.create(DepartmentService.class);
	
	private Label lNameFault = new Label();
	private Label lManagerFault = new Label();
	private VerticalPanel faultMessages = new VerticalPanel();
	
	private TextBox name = new TextBox();
	private TextBox total = new TextBox();	
	private ListBox manager = new ListBox(false);
	private ListBox parent = new ListBox(false);
	
	private Button save = new Button("save");
	private Button cut = new Button("cut");
	
	private Integer department;	
	
	private TreePanel tree;
	
	public DepartmentPanel(TreePanel tree) {
		this.tree = tree;
		
		total.setReadOnly(true);
		name.setWidth("300px");
		total.setWidth("300px");
		manager.setHeight("28px");
		parent.setHeight("28px");
		
		cut.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				departmentService.cut(department, new AsyncCallback<Double>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess(Double result) {
						DepartmentPanel.this.total.setText(Double.toString(result));
					}
				});
			}
		});
		
		save.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (validate()) {
					int parentIndex;
					int managerIndex;
					
					Integer parentDep = null;
					Integer managerEmp = null;
					
					parentIndex = parent.getSelectedIndex();
					managerIndex = manager.getSelectedIndex();
					
					if (parentIndex > 0) {
						parentDep = Integer.parseInt(parent.getValue(parentIndex));
					}
					
					if (managerIndex > 0) {
						managerEmp = Integer.parseInt(manager.getValue(managerIndex));
					}
				
				
					departmentService.saveDepartment(department,
							name.getText(), parentDep, managerEmp,
							new AsyncCallback<DepartmentInfo>() {

								@Override
								public void onFailure(Throwable caught) {
									if (caught instanceof ServerValidationException) {
										lNameFault.setText("*");
										faultMessages.add(new Label(caught.getMessage()));
									} else {
										Window.alert(caught.getMessage());
									}
								}

								@Override
								public void onSuccess(DepartmentInfo result) {
									clearFields();
									initFields(result);
									DepartmentPanel.this.tree.refreshTree();
								}
							});
				}
			}
		});
		
		Grid grid = new Grid(4, 3);
		
		Label lname = new Label("Name:");
		lname.setWidth("60px");
		
		lNameFault.setStylePrimaryName("error");
		lManagerFault.setStylePrimaryName("error");
		faultMessages.setStylePrimaryName("error");
		faultMessages.setSpacing(5);
		
		grid.setWidget(0, 0, lname);
		grid.setWidget(1, 0, new Label("Total:"));
		grid.setWidget(2, 0, new Label("Manager:"));
		grid.setWidget(3, 0, new Label("Parent:"));
		
		grid.setWidget(0, 1, name);
		grid.setWidget(1, 1, total);
		grid.setWidget(2, 1, manager);
		grid.setWidget(3, 1, parent);
		
		grid.setWidget(0, 2, lNameFault);
		grid.setWidget(2, 2, lManagerFault);

		add(grid);
		
		HorizontalPanel buttons = new HorizontalPanel();
		
		buttons.setSpacing(5);
		
		buttons.add(save);
		buttons.add(cut);
		
		add(buttons);
		
		add(faultMessages);
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
		
		clearFields();
		
		departmentService.getDepartment(department, new AsyncCallback<DepartmentInfo>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(DepartmentInfo result) {
				initFields(result);
			}
		});
	}
	
	private void clearFields() {
		resetFaultMessages();
		name.setText("");
		total.setText("");
		manager.clear();
		parent.clear();
	}

	private boolean validate() {
		resetFaultMessages();
		
		boolean valid = true;
		
		if (name.getText() == null || name.getText().length() == 0) {
			lNameFault.setText("*");
			faultMessages.add(new Label("Enter a valid name, please."));
			valid = false;
		}
		if (manager.getSelectedIndex() == 0) {
			lManagerFault.setText("*");
			faultMessages.add(new Label("Select a valid manager, please."));
			valid = false;
		}
		return valid;
	}

	private void resetFaultMessages() {
		lNameFault.setText("");
		lManagerFault.setText("");
		faultMessages.clear();
	}
	
	private void initFields(DepartmentInfo result) {
		resetFaultMessages();
		
		department = result.getId();
		
		if (!result.isNewDepartment()) {
			name.setText(result.getName());
			total.setText(Double.toString(result.getTotal()));
		}
		
		cut.setEnabled(!result.isNewDepartment());
		
		int i = 0;
		int index = i;
		
		parent.addItem(null);
		
		for (Integer key : result.getOtherDepartments().keySet()) {
			parent.addItem(result.getOtherDepartments().get(key), Integer.toString(key));
			if (!result.isNewDepartment()) {
				i++;
				if (key.equals(result.getParentDepartment())) {
					index = i;
				}
			}
		}
		parent.setSelectedIndex(index);
		
		manager.addItem(null);
		i = 0;
		index = i;
		for (Integer key: result.getAllEmployees().keySet()) {
			manager.addItem(result.getAllEmployees().get(key), Integer.toString(key));
			if (!result.isNewDepartment()) {
				i++;
				if (key.equals(result.getManager())) {
					index = i;
				}
			}
		}
		manager.setSelectedIndex(index);
	}
	
}
