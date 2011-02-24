package org.softlang.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.softlang.company.Company;
import org.softlang.company.Dept;
import org.softlang.company.Subunit;

public class DeptView {

	private final Controller controller;
	private final JPanel namePanel, managerPanel, employeePanel, subDeptPanel,
			salaryPanel, buttonPanel;
	private final JFrame frame;
	private final JTextField nameField;
	private final JButton managerButton, cutButton, saveButton, okButton,
			cancelButton;
	private final JList employeeList;
	private final DefaultListModel employeeListModel;
	private final JLabel subDeptLabel, salaryLabel;
	private final JList subDeptList;
	private final DefaultListModel subDeptListModel;
	private boolean isTop;

	public DeptView(Controller controller) {
		this.controller = controller;
		frame = new JFrame();
		namePanel = new JPanel(new GridLayout(1, 2, 0, 0));
		managerPanel = new JPanel(new GridLayout(1, 2, 66, 0));
		employeePanel = new JPanel(new GridLayout(1, 2, 30, 0));
		subDeptPanel = new JPanel(new GridLayout(1, 2, 20, 0));
		salaryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		buttonPanel = new JPanel(new GridLayout(1, 3, 20, 0));
		subDeptLabel = new JLabel();
		salaryLabel = new JLabel();
		cutButton = new JButton();
		saveButton = new JButton();
		okButton = new JButton();
		cancelButton = new JButton();
		nameField = new JTextField();
		managerButton = new JButton();
		employeeListModel = new DefaultListModel();
		subDeptListModel = new DefaultListModel();
		employeeList = new JList(employeeListModel);
		subDeptList = new JList(subDeptListModel);
		init();
	}

	public void showCompany(final Company company, double total) {
		isTop = true;
		setNonTopPanelVisibilty(false);
		removeListener();
		subDeptListModel.clear();
		frame.setTitle("Company");
		nameField.setText(company.getName());
		salaryLabel.setText("Total salary = " + Double.toString(total) + " $");
		cutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cutCompanyClicked();
			}
		});
		subDeptLabel.setText("Top departments: ");
		for (Dept dept : company.getDepts())
			addDept(dept);
		frame.setVisible(true);

	}

	public void showDept(final Dept dept, double total) {
		isTop = false;
		setNonTopPanelVisibilty(true);
		removeListener();
		employeeListModel.clear();
		subDeptListModel.clear();
		frame.setTitle("Department  \"" + dept.getName() + "\"");
		salaryLabel.setText("Total salary = " + Double.toString(total) + " $");
		subDeptLabel.setText("Sub departments: ");
		nameField.setText(dept.getName());
		cutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cutDeptClicked();
			}
		});
		managerButton.setText(dept.getManager().getPerson().getName());
		if (managerButton.getActionListeners().length != 0)
			managerButton.removeActionListener(managerButton
					.getActionListeners()[0]);
		managerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.employeeClicked(dept.getManager());
			}
		});
		for (Subunit subunit : dept.getSubunits()) {
			addSubunit(subunit);
		}
	}

	private void removeListener() {
		for (ActionListener al : cutButton.getActionListeners())
			cutButton.removeActionListener(al);
		for (ActionListener al : managerButton.getActionListeners())
			managerButton.removeActionListener(al);
		for (ListSelectionListener lsl : employeeList
				.getListSelectionListeners())
			employeeList.removeListSelectionListener(lsl);
		for (ListSelectionListener lsl : subDeptList
				.getListSelectionListeners())
			subDeptList.removeListSelectionListener(lsl);
	}

	private void setNonTopPanelVisibilty(boolean visibility) {
		managerPanel.setVisible(visibility);
		employeePanel.setVisible(visibility);
		okButton.setVisible(visibility);
		cancelButton.setVisible(visibility);
	}

	private void addSubunit(final Subunit subunit) {
		if (subunit.getPu() != null) {
			final int newIndex = employeeListModel.size();
			employeeListModel.add(newIndex, subunit.getPu().getPerson()
					.getName());
			employeeList.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (employeeList.getSelectedIndex() == newIndex)
						controller.employeeClicked(subunit.getPu());

				}
			});
		} else {
			final int newIndex = subDeptListModel.size();
			subDeptListModel.add(newIndex, subunit.getDu().getName());
			subDeptList.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (subDeptList.getSelectedIndex() == newIndex)
						controller.deptClicked(subunit.getDu());

				}
			});
		}
	}

	private void addDept(final Dept dept) {
		final int newIndex = subDeptListModel.size();
		subDeptListModel.add(newIndex, dept.getName());
		subDeptList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (subDeptList.getSelectedIndex() == newIndex)
					controller.deptClicked(dept);

			}
		});

	}

	private void init() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "ESCAPE");
		frame.getRootPane().getActionMap().put("ESCAPE", new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.deptOrCompanyClosed();
			}
		});
		JLabel nameLabel = new JLabel("Name:");
		namePanel.add(nameLabel);
		nameField.setColumns(10);
		namePanel.add(nameField);
		nameField.setPreferredSize(new Dimension(10, 20));
		panel.add(namePanel);

		JLabel managerLabel = new JLabel("Manager:");
		managerPanel.add(managerLabel);
		managerButton.setPreferredSize(new Dimension(80, 25));
		managerPanel.add(managerButton);
		panel.add(managerPanel);

		JLabel employeesLabel = new JLabel("Employees:");
		employeePanel.add(employeesLabel);
		employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane emplScrollPane = new JScrollPane(employeeList);
		emplScrollPane.setPreferredSize(new Dimension(100, 100));
		employeePanel.add(emplScrollPane);
		panel.add(employeePanel);

		subDeptPanel.add(subDeptLabel);
		subDeptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane subDeptScrollPane = new JScrollPane(subDeptList);
		subDeptScrollPane.setPreferredSize(new Dimension(80, 100));
		subDeptPanel.add(subDeptScrollPane);
		panel.add(subDeptPanel);

		salaryLabel.setSize(10, 10);
		salaryPanel.add(salaryLabel);
		cutButton.setText("Cut");
		cutButton.setSize(new Dimension(10, 25));
		salaryPanel.add(cutButton);
		panel.add(salaryPanel);

		saveButton.setText("Save");
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (isTop)
					controller.saveCompanyClicked(nameField.getText());
				else
					controller.saveDeptClicked(nameField.getText());
			}
		});
		buttonPanel.add(saveButton);
		okButton.setText("Ok");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.okDeptClicked(nameField.getText());
			}
		});
		buttonPanel.add(okButton);
		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.cancelDeptClicked();

			}
		});
		buttonPanel.add(cancelButton);
		panel.add(buttonPanel);

		frame.getContentPane().add(panel);
		frame.setLocation(170, 250);
		frame.setSize(290, 550);
		frame.setResizable(false);
	}

}
