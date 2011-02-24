package org.softlang.client;

import java.util.Stack;

import org.softlang.client.companyInfo.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt implements EntryPoint {

	private final ServiceAsync service = GWT.create(Service.class);
	private Stack<String> deptStack = new Stack<String>();
	private final AbsolutePanel all = new AbsolutePanel();

	private CompanyInfo companyInfo;
	private DeptInfo deptInfo;
	private EmployeeInfo employeeInfo;

	public void onModuleLoad() {
		all.setStyleName("all");
		RootPanel.get().add(all);
		HorizontalPanel footer = new HorizontalPanel();
		footer.setStyleName("footer2");
		RootPanel.get().add(footer);
		loadShowCompany();
	}

	public void loadShowCompany() {
		service.getCompanyInfo(new AsyncCallback<CompanyInfo>() {

			@Override
			public void onSuccess(CompanyInfo result) {
				companyInfo = result;
				showCompany();
			}

			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}

	public void showCompany() {
		final VerticalPanel topPanel = new VerticalPanel();
		final HorizontalPanel namePanel = new HorizontalPanel();
		final HorizontalPanel borderPanel = new HorizontalPanel();
		final HorizontalPanel salaryPanel = new HorizontalPanel();
		final VerticalPanel borderPanel1 = new VerticalPanel();
		final HorizontalPanel deptsPanelTop = new HorizontalPanel();
		final VerticalPanel deptPanel = new VerticalPanel();

		final TextBox nameEditBox = new TextBox();

		topPanel.setStyleName("topPanel");
		final HorizontalPanel menuPanel = new HorizontalPanel();
		menuPanel.setStyleName("menuPanel");
		final Button saveButton = new Button("Save");
		saveButton.setStyleName("saveButton");
		saveButton.setEnabled(false);
		saveButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				companyInfo.setName(nameEditBox.getText());
				service.saveCompanyInfo(companyInfo.getName(),
						new AsyncCallback<Void>() {

							@Override
							public void onSuccess(Void result) {
								saveButton.setEnabled(false);

							}

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}
						});
			}
		});
		menuPanel.add(saveButton);
		topPanel.add(menuPanel);
		final HorizontalPanel topInnerPanel = new HorizontalPanel();
		topInnerPanel.setStyleName("topInnerPanel");
		final Label infoTopText = new Label("Company ");
		infoTopText.setStyleName("viewInfo");
		topInnerPanel.add(infoTopText);
		final Label deptNameText = new Label("\"" + companyInfo.getName()
				+ "\"");
		deptNameText.setStyleName("viewInfoExtCompany");
		topInnerPanel.add(deptNameText);
		topPanel.add(topInnerPanel);
		all.add(topPanel);

		namePanel.setStyleName("companyInfoPanel");
		final Label nameInfoText = new Label("Name: ");
		nameInfoText.setStyleName("companyInfoText");
		namePanel.add(nameInfoText);
		nameEditBox.setText(companyInfo.getName());
		nameEditBox.setStyleName("companyEditBoxOff");
		nameEditBox.setReadOnly(true);
		namePanel.add(nameEditBox);
		final Button nameEditButton = new Button("Edit");
		nameEditButton.setStyleName("editButton");
		nameEditButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (nameEditBox.isReadOnly()) {
					nameEditBox.setReadOnly(false);
					nameEditBox.setStyleName("companyEditBox");
					nameEditButton.setText("done");
				} else {
					nameEditBox.setReadOnly(true);
					nameEditBox.setStyleName("companyEditBoxOff");
					nameEditButton.setText("edit");
					saveButton.setEnabled(!nameEditBox.getText().equals(
							companyInfo.getName()));
					deptNameText.setText("\"" + nameEditBox.getText() + "\"");
				}
			}
		});
		namePanel.add(nameEditButton);
		all.add(namePanel);

		borderPanel.addStyleName("borderPanel");
		all.add(borderPanel);

		deptsPanelTop.setStyleName("listTop");
		final Label subDeptsInfoText = new Label("Top Departments:");
		subDeptsInfoText.setStyleName("listInfo");
		deptsPanelTop.add(subDeptsInfoText);
		all.add(deptPanel);
		all.add(deptsPanelTop);

		deptPanel.setStyleName("list");
		for (int i = 0; i < companyInfo.getDeptsInfos().size(); i++) {
			final int finali = i;
			HorizontalPanel butPanel = new HorizontalPanel();
			butPanel.setStyleName("butPanel");
			Button curDeptButton = new Button(companyInfo.getDeptsInfos()
					.get(i));
			curDeptButton.setStyleName("deptButton");
			curDeptButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					all.clear();
					loadShowDept(companyInfo.getDeptsInfos().get(finali));
				}
			});
			butPanel.add(curDeptButton);
			deptPanel.add(butPanel);
		}
		all.add(deptPanel);
		borderPanel1.addStyleName("salaryBorderPanel");
		all.add(borderPanel1);

		salaryPanel.setStyleName("salaryPanel");
		final Label salaryInfoValue = new Label();
		service.getCompanyTotal(new AsyncCallback<Double>() {

			@Override
			public void onSuccess(Double result) {
				salaryInfoValue.setText("Total salary = " + result + " $");
			}

			@Override
			public void onFailure(Throwable caught) {
			}
		});
		salaryInfoValue.setStyleName("salaryInfo");
		salaryPanel.add(salaryInfoValue);
		Button cutButton = new Button("Cut");
		cutButton.setStyleName("cutButton");
		cutButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				service.cutCompany(new AsyncCallback<Double>() {

					@Override
					public void onSuccess(Double result) {
						salaryInfoValue.setText("Total salary = " + result
								+ " $");
					}

					@Override
					public void onFailure(Throwable caught) {
					}
				});
			}
		});
		salaryPanel.add(cutButton);
		all.add(salaryPanel);

	}

	public void loadShowDept(String deptName) {
		service.getDeptInfo(deptName, new AsyncCallback<DeptInfo>() {

			@Override
			public void onSuccess(DeptInfo result) {
				deptInfo = result;
				showDept();
			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});
	}

	public void showDept() {
		final VerticalPanel topPanel = new VerticalPanel();
		final HorizontalPanel namePanel = new HorizontalPanel();
		final VerticalPanel borderPanel = new VerticalPanel();
		final HorizontalPanel managerPanel = new HorizontalPanel();
		final VerticalPanel borderPanel2 = new VerticalPanel();
		final HorizontalPanel employeesPanelTop = new HorizontalPanel();
		final VerticalPanel employeesPanel = new VerticalPanel();
		final VerticalPanel borderPanel3 = new VerticalPanel();
		final HorizontalPanel subDeptsPanelTop = new HorizontalPanel();
		final VerticalPanel subDeptsPanel = new VerticalPanel();
		final VerticalPanel borderPanel4 = new VerticalPanel();
		final HorizontalPanel salaryPanel = new HorizontalPanel();

		final TextBox nameEditBox = new TextBox();

		topPanel.setStyleName("topPanel");
		final HorizontalPanel menuPanel = new HorizontalPanel();
		menuPanel.setStyleName("menuPanel");

		final Button okButton = new Button("Ok");
		final Button saveButton = new Button("Save");
		saveButton.setStyleName("saveButton");
		saveButton.setEnabled(false);
		saveButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String oldDeptName = deptInfo.getName();
				deptInfo.setName(nameEditBox.getText());
				service.saveDeptInfo(oldDeptName, deptInfo.getName(),
						new AsyncCallback<Void>() {

							@Override
							public void onSuccess(Void result) {
								saveButton.setEnabled(false);
								okButton.setEnabled(false);

							}

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}
						});
			}
		});
		menuPanel.add(saveButton);

		okButton.setStyleName("okButton");
		okButton.setEnabled(false);
		okButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String oldDeptName = deptInfo.getName();
				deptInfo.setName(nameEditBox.getText());
				service.saveDeptInfo(oldDeptName, deptInfo.getName(),
						new AsyncCallback<Void>() {

							@Override
							public void onSuccess(Void result) {
								all.clear();
								if (deptStack.isEmpty())
									loadShowCompany();
								else
									loadShowDept(deptStack.pop());

							}

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}
						});
			}
		});
		menuPanel.add(okButton);

		final Button cancelButton = new Button("Cancel");
		cancelButton.setStyleName("navButton");
		cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				all.clear();
				if (deptStack.isEmpty())
					loadShowCompany();
				else
					loadShowDept(deptStack.pop());
			}
		});
		menuPanel.add(cancelButton);

		topPanel.add(menuPanel);

		topPanel.add(menuPanel);
		final HorizontalPanel topInnerPanel = new HorizontalPanel();
		topInnerPanel.setStyleName("topInnerPanel");
		final Label infoTopText = new Label("Department ");
		infoTopText.setStyleName("viewInfo");
		topInnerPanel.add(infoTopText);
		final Label deptNameText = new Label("\"" + deptInfo.getName() + "\"");
		deptNameText.setStyleName("viewInfoExtDept");
		topInnerPanel.add(deptNameText);
		topPanel.add(topInnerPanel);
		all.add(topPanel);

		namePanel.setStyleName("deptInfoPanel");
		final Label nameInfoText = new Label("Name: ");
		nameInfoText.setStyleName("deptInfoText");
		namePanel.add(nameInfoText);
		nameEditBox.setText(deptInfo.getName());
		nameEditBox.setStyleName("deptEditBoxOff");
		nameEditBox.setReadOnly(true);
		namePanel.add(nameEditBox);
		final Button nameEditButton = new Button("Edit");
		nameEditButton.setStyleName("editButton");
		nameEditButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (nameEditBox.isReadOnly()) {
					nameEditBox.setReadOnly(false);
					nameEditBox.setStyleName("deptEditBox");
					nameEditButton.setText("done");
				} else {
					nameEditBox.setReadOnly(true);
					nameEditBox.setStyleName("deptEditBoxOff");
					nameEditButton.setText("edit");
					saveButton.setEnabled(!nameEditBox.getText().equals(
							deptInfo.getName()));
					okButton.setEnabled(!nameEditBox.getText().equals(
							deptInfo.getName()));
					deptNameText.setText("\"" + nameEditBox.getText() + "\"");
				}
			}
		});
		namePanel.add(nameEditButton);
		all.add(namePanel);

		borderPanel.addStyleName("borderPanel");
		all.add(borderPanel);

		managerPanel.setStyleName("managerPanel");
		Label managerInfo = new Label("Manager: ");
		managerInfo.setStyleName("managerInfo");
		managerPanel.add(managerInfo);
		Button managerButton = new Button();
		managerButton.setText(deptInfo.getManagerInfo());
		managerButton.setStyleName("employeeButton");
		managerButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				all.clear();
				deptStack.push(deptInfo.getName());
				loadShowEmployee(deptInfo.getManagerInfo());
			}
		});

		managerPanel.add(managerButton);
		all.add(managerPanel);

		borderPanel2.addStyleName("borderPanel");
		all.add(borderPanel2);

		employeesPanelTop.setStyleName("listTop");
		final Label employeesInfoText = new Label("Employees:");
		employeesInfoText.setStyleName("listInfo");
		employeesPanelTop.add(employeesInfoText);

		all.add(employeesPanelTop);

		employeesPanel.setStyleName("list");
		for (int i = 0; i < deptInfo.getSubunitsInfos().size(); i++) {
			final int finali = i;
			if (deptInfo.getSubunitsInfos().get(finali).getPuInfo() != null) {
				HorizontalPanel butPanel = new HorizontalPanel();
				butPanel.setStyleName("butPanel");
				Button curEmplButton = new Button(deptInfo.getSubunitsInfos()
						.get(finali).getPuInfo());
				curEmplButton.setStyleName("employeeButton");
				curEmplButton.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						all.clear();
						deptStack.push(deptInfo.getName());
						loadShowEmployee(deptInfo.getSubunitsInfos()
								.get(finali).getPuInfo());

					}
				});
				butPanel.add(curEmplButton);
				employeesPanel.add(butPanel);
				butPanel.setHeight("40px");
			}
		}

		all.add(employeesPanel);

		borderPanel3.addStyleName("borderPanel");
		all.add(borderPanel3);

		subDeptsPanelTop.setStyleName("listTop");
		final Label subDeptsInfoText = new Label("Sub Departments:");
		subDeptsInfoText.setStyleName("listInfo");
		subDeptsPanelTop.add(subDeptsInfoText);
		all.add(subDeptsPanel);
		all.add(subDeptsPanelTop);

		subDeptsPanel.setStyleName("list");
		for (int i = 0; i < deptInfo.getSubunitsInfos().size(); i++) {
			final int finali = i;
			if (deptInfo.getSubunitsInfos().get(finali).getDuInfo() != null) {
				HorizontalPanel butPanel = new HorizontalPanel();
				butPanel.setStyleName("butPanel");
				Button curDeptButton = new Button(deptInfo.getSubunitsInfos()
						.get(finali).getDuInfo());
				curDeptButton.setStyleName("deptButton");
				curDeptButton.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						all.clear();
						deptStack.push(deptInfo.getName());
						loadShowDept(deptInfo.getSubunitsInfos().get(finali)
								.getDuInfo());
					}
				});
				butPanel.add(curDeptButton);
				subDeptsPanel.add(butPanel);
				butPanel.setHeight("40px");
			}
		}

		all.add(subDeptsPanel);

		borderPanel4.addStyleName("salaryBorderPanel");
		all.add(borderPanel4);

		salaryPanel.setStyleName("salaryPanel");
		final Label salaryInfoValue = new Label();
		service.getDeptTotal(deptInfo.getName(), new AsyncCallback<Double>() {

			@Override
			public void onSuccess(Double result) {
				salaryInfoValue.setText("Total salary = " + result + " $");
			}

			@Override
			public void onFailure(Throwable caught) {
			}
		});

		salaryInfoValue.setStyleName("salaryInfo");
		salaryPanel.add(salaryInfoValue);
		Button cutButton = new Button("Cut");
		cutButton.setStyleName("cutButton");
		cutButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				service.cutDept(deptInfo.getName(),
						new AsyncCallback<Double>() {

							@Override
							public void onSuccess(Double result) {
								salaryInfoValue.setText("Total salary = "
										+ result + " $");
							}

							@Override
							public void onFailure(Throwable caught) {
							}
						});
			}
		});
		salaryPanel.add(cutButton);
		all.add(salaryPanel);

	}

	public void loadShowEmployee(String employeeName) {
		service.getEmployeeInfo(employeeName,
				new AsyncCallback<EmployeeInfo>() {

					@Override
					public void onSuccess(EmployeeInfo result) {
						employeeInfo = result;
						showEmployee();

					}

					@Override
					public void onFailure(Throwable caught) {
					}
				});
	}

	// Display given employee

	public void showEmployee() {
		final VerticalPanel topPanel = new VerticalPanel();
		final HorizontalPanel namePanel = new HorizontalPanel();
		final HorizontalPanel addressPanel = new HorizontalPanel();
		final HorizontalPanel salaryPanel = new HorizontalPanel();

		final TextBox nameEditBox = new TextBox();
		final TextBox addressEditBox = new TextBox();
		final TextBox salaryEditBox = new TextBox();

		topPanel.setStyleName("topPanel");
		final HorizontalPanel menuPanel = new HorizontalPanel();
		menuPanel.setStyleName("menuPanel");
		final Button okButton = new Button("Ok");
		final Button saveButton = new Button("Save");
		saveButton.setStyleName("saveButton");
		saveButton.setEnabled(false);
		saveButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String oldEmployeeName = employeeInfo.getName();
				employeeInfo.setName(nameEditBox.getText());
				employeeInfo.setAddress(addressEditBox.getText());
				employeeInfo.setSalary(Double.valueOf(salaryEditBox.getText()
						.substring(0, salaryEditBox.getText().length() - 2)));
				service.saveEmployeeInfo(oldEmployeeName, employeeInfo,
						new AsyncCallback<Void>() {

							@Override
							public void onSuccess(Void result) {
								saveButton.setEnabled(false);
								okButton.setEnabled(false);

							}

							@Override
							public void onFailure(Throwable caught) {

							}
						});
			}
		});
		menuPanel.add(saveButton);

		okButton.setStyleName("okButton");
		okButton.setEnabled(false);
		okButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String oldEmployeeName = employeeInfo.getName();
				employeeInfo.setName(nameEditBox.getText());
				employeeInfo.setAddress(addressEditBox.getText());
				employeeInfo.setSalary(Double.valueOf(salaryEditBox.getText()
						.substring(0, salaryEditBox.getText().length() - 2)));
				service.saveEmployeeInfo(oldEmployeeName, employeeInfo,
						new AsyncCallback<Void>() {

							@Override
							public void onSuccess(Void result) {
								all.clear();
								loadShowDept(deptStack.pop());

							}

							@Override
							public void onFailure(Throwable caught) {

							}
						});
			}
		});
		menuPanel.add(okButton);

		final Button cancelButton = new Button("Cancel");
		cancelButton.setStyleName("navButton");
		cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				all.clear();
				loadShowDept(deptStack.pop());
			}
		});
		menuPanel.add(cancelButton);

		topPanel.add(menuPanel);
		final HorizontalPanel topInnerPanel = new HorizontalPanel();
		topInnerPanel.setStyleName("topInnerPanel");
		final Label infoTopText = new Label("Employee ");
		infoTopText.setStyleName("viewInfo");
		topInnerPanel.add(infoTopText);
		final Label employeeNameText = new Label("\"" + employeeInfo.getName()
				+ "\"");
		employeeNameText.setStyleName("viewInfoExtEmpl");
		topInnerPanel.add(employeeNameText);
		topPanel.add(topInnerPanel);
		all.add(topPanel);
		//
		namePanel.setStyleName("empInfoPanel");
		final Label nameInfoText = new Label("Name : ");
		nameInfoText.setStyleName("empInfoText");
		namePanel.add(nameInfoText);
		nameEditBox.setText(employeeInfo.getName());
		nameEditBox.setStyleName("empEditBoxOff");
		nameEditBox.setReadOnly(true);
		namePanel.add(nameEditBox);
		final Button nameEditButton = new Button("Edit");
		nameEditButton.setStyleName("editButton");
		nameEditButton.addClickHandler(new ClickHandler() {
			//
			@Override
			public void onClick(ClickEvent event) {
				if (nameEditBox.isReadOnly()) {
					nameEditBox.setReadOnly(false);
					nameEditBox.setStyleName("empEditBox");
					nameEditButton.setText("Done");
				} else {
					nameEditBox.setReadOnly(true);
					nameEditBox.setStyleName("empEditBoxOff");
					nameEditButton.setText("Edit");
					saveButton.setEnabled(!nameEditBox.getText().equals(
							employeeInfo.getName()));
					okButton.setEnabled(!nameEditBox.getText().equals(
							employeeInfo.getName()));
					employeeNameText.setText("\"" + nameEditBox.getText()
							+ "\"");
				}
				//
			}
		});
		namePanel.add(nameEditButton);
		all.add(namePanel);
		//
		addressPanel.setStyleName("empInfoPanel");
		final Label addressInfoText = new Label("Address : ");
		addressInfoText.setStyleName("empInfoText");
		addressPanel.add(addressInfoText);
		addressEditBox.setText(employeeInfo.getAddress());
		addressEditBox.setStyleName("empEditBoxOff");
		addressEditBox.setReadOnly(true);
		addressPanel.add(addressEditBox);
		final Button addressEditButton = new Button("Edit");
		addressEditButton.setStyleName("editButton");
		addressEditButton.addClickHandler(new ClickHandler() {
			//
			@Override
			public void onClick(ClickEvent event) {
				if (addressEditBox.isReadOnly()) {
					addressEditBox.setReadOnly(false);
					addressEditBox.setStyleName("empEditBox");
					addressEditButton.setText("Done");
				} else {
					addressEditBox.setReadOnly(true);
					addressEditBox.setStyleName("empEditBoxOff");
					addressEditButton.setText("Edit");
					saveButton.setEnabled(!addressEditBox.getText().equals(
							employeeInfo.getAddress()));
					okButton.setEnabled(!addressEditBox.getText().equals(
							employeeInfo.getAddress()));

				}
			}
		});
		addressPanel.add(addressEditButton);
		all.add(addressPanel);
		//
		salaryPanel.setStyleName("empInfoPanel");
		final Label salaryInfoText = new Label("Salary : ");
		salaryInfoText.setStyleName("empInfoText");
		salaryPanel.add(salaryInfoText);
		salaryEditBox.setText(Double.toString(employeeInfo.getSalary()) + " $");
		salaryEditBox.setStyleName("empEditBoxOff");
		salaryEditBox.setReadOnly(true);
		salaryPanel.add(salaryEditBox);
		final Button salaryEditButton = new Button("Edit");
		salaryEditButton.setStyleName("editButton");
		salaryEditButton.addClickHandler(new ClickHandler() {
			//
			@Override
			public void onClick(ClickEvent event) {
				if (salaryEditBox.isReadOnly()) {
					salaryEditBox.setReadOnly(false);
					salaryEditBox.setStyleName("empEditBox");
					salaryEditBox.setText(salaryEditBox.getText().substring(0,
							salaryEditBox.getText().length() - 2));
					salaryEditButton.setText("Done");
				} else {
					salaryEditBox.setReadOnly(true);
					salaryEditBox.setStyleName("empEditBoxOff");
					salaryEditButton.setText("Edit");
					try {
						double newSalary = Double.valueOf(salaryEditBox
								.getText());
						saveButton.setEnabled(newSalary != employeeInfo
								.getSalary());
						okButton.setEnabled(newSalary != employeeInfo
								.getSalary());

					} catch (NumberFormatException e) {
						salaryEditBox.setText(Double.toString(employeeInfo
								.getSalary()));
					}
					salaryEditBox.setText(salaryEditBox.getText() + " $");
				}
			}
		});
		salaryPanel.add(salaryEditButton);
		final Button cutButton = new Button("Cut");
		cutButton.addClickHandler(new ClickHandler() {
			//
			@Override
			public void onClick(ClickEvent event) {
				service.cutEmployee(
						employeeInfo.getName(),
						Double.valueOf(salaryEditBox.getText().substring(0,
								salaryEditBox.getText().length() - 2)),
						new AsyncCallback<Double>() {
							@Override
							public void onSuccess(Double result) {
								employeeInfo.setSalary(result);
								salaryEditBox.setText(result + " $");
							}

							@Override
							public void onFailure(Throwable caught) {
							}
						});
			}
		});
		cutButton.setStyleName("cutButton");
		salaryPanel.add(cutButton);
		all.add(salaryPanel);
	}
}