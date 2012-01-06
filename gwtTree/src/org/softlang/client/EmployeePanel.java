package org.softlang.client;

import org.softlang.client.guiinfos.EmployeeInfo;
import org.softlang.client.interfaces.EmployeeService;
import org.softlang.client.interfaces.EmployeeServiceAsync;
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

public class EmployeePanel extends VerticalPanel {
	
	private final EmployeeServiceAsync employeeService = GWT.create(EmployeeService.class);
	
	private Label lNameFault = new Label();
	private Label lAddressFault = new Label();
	private Label lSalaryFault = new Label();
	private VerticalPanel faultMessages = new VerticalPanel();
	
	private TextBox name = new TextBox();
	private TextBox address = new TextBox();
	private TextBox total = new TextBox();
	private ListBox parent = new ListBox(false);
	
	private Button save = new Button("save");
	private Button cut = new Button("cut");

	private Integer employee;

	private TreePanel tree;
	
	public EmployeePanel(TreePanel tree) {
		this.tree = tree;
		
		name.setWidth("300px");
		address.setWidth("300px");
		total.setWidth("300px");
		parent.setHeight("28px");
		
		cut.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				employeeService.cut(employee, new AsyncCallback<Double>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess(Double result) {
						total.setText(Double.toString(result));
					}
				});
			}
		});
		
		save.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				
				if (validate()) {
					int parentIndex;
					Integer parentDep = null;
					parentIndex = parent.getSelectedIndex();
					if (parentIndex > 0) {
						parentDep = Integer.parseInt(parent
								.getValue(parentIndex));
					}
					employeeService.saveEmployee(employee, name.getText(),
							address.getText(),
							Double.parseDouble(total.getText()), parentDep,
							new AsyncCallback<EmployeeInfo>() {

								@Override
								public void onFailure(Throwable caught) {
									if (caught instanceof ServerValidationException) {
										ServerValidationException ex = (ServerValidationException) caught;
										if (ex.getField() == ServerValidationException.Field.NAME) {
											lNameFault.setText("*");
											
										} else if (ex.getField() == ServerValidationException.Field.SALARY) {
											lSalaryFault.setText("*");
										}
										faultMessages.add(new Label(caught.getMessage()));
									} else {
										Window.alert(caught.getMessage());
									}
								}

								@Override
								public void onSuccess(EmployeeInfo result) {
									clearFields();
									initFields(result);
									EmployeePanel.this.tree.refreshTree();
								}
							});
				}
			}
			
		});
		
		Grid grid = new Grid(4, 3);
		
		Label lname = new Label("Name:");
		lname.setWidth("60px");
		
		lNameFault.setStylePrimaryName("error");
		lAddressFault.setStylePrimaryName("error");
		lSalaryFault.setStylePrimaryName("error");
		faultMessages.setStylePrimaryName("error");
		faultMessages.setSpacing(5);
		
		grid.setWidget(0, 0, lname);
		grid.setWidget(1, 0, new Label("Address:"));
		grid.setWidget(2, 0, new Label("Salary:"));
		grid.setWidget(3, 0, new Label("Parent:"));
		
		grid.setWidget(0, 1, name);
		grid.setWidget(1, 1, address);
		grid.setWidget(2, 1, total);
		grid.setWidget(3, 1, parent);
		
		grid.setWidget(0, 2, lNameFault);
		grid.setWidget(1, 2, lAddressFault);
		grid.setWidget(2, 2, lSalaryFault);

		add(grid);
		
		HorizontalPanel buttons = new HorizontalPanel();
		
		buttons.setSpacing(5);
		
		buttons.add(save);
		buttons.add(cut);
		
		add(buttons);
		
		add(faultMessages);
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
		
		clearFields();
		
		employeeService.getEmployee(employee, new AsyncCallback<EmployeeInfo>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(EmployeeInfo result) {
				initFields(result);
			}
			
		});
	}
	
	private void clearFields() {
		resetFaultMessages();
		name.setText("");
		address.setText("");
		total.setText("");
		parent.clear();
	}
	
	private void initFields(EmployeeInfo result) {
		employee = result.getId();
		
		if (!result.isNewEmployee()) {
			name.setText(result.getName());
			address.setText(result.getAddress());
			total.setText(Double.toString(result.getTotal()));
		}
		
		cut.setEnabled(!result.isNewEmployee());
		
		int i = 0;
		int index = i;
		
		parent.addItem(null);
		
		for (Integer key : result.getAllDepartments().keySet()) {
			parent.addItem(result.getAllDepartments().get(key), Integer.toString(key));
			if (!result.isNewEmployee()) {
				i++;
				if (key.equals(result.getParent())) {
					index = i;
				}
			}
		}
		parent.setSelectedIndex(index);
	}
	
	private boolean validate() {
		resetFaultMessages();
		
		boolean valid = true;
		
		if (name.getText() == null || name.getText().length() == 0) {
			lNameFault.setText("*");
			faultMessages.add(new Label("Enter a valid name, please."));
			valid = false;
		}
		if (address.getText() == null || address.getText().length() == 0) {
			lAddressFault.setText("*");
			faultMessages.add(new Label("Enter a valid address, please."));
			valid = false;
		}
		if (total.getText() == null || total.getText().length() == 0) {
			lNameFault.setText("*");
			faultMessages.add(new Label("Enter a valid salary, please."));
			valid = false;
		} else {
			try {
				Double.parseDouble(total.getText());
			} catch (NumberFormatException e) {
				lNameFault.setText("*");
				faultMessages.add(new Label("Enter a valid salary, please."));
				valid = false;
			}
		}
		return valid;
	}

	private void resetFaultMessages() {
		lNameFault.setText("");
		lAddressFault.setText("");
		lSalaryFault.setText("");
		faultMessages.clear();
	}
	
}
