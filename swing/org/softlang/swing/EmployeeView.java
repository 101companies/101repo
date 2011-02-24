package org.softlang.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.softlang.company.Employee;

public class EmployeeView {

	private final Controller controller;

	private final JFrame frame;
	private final JTextField nameField;
	private final JTextField addressField;
	private final JTextField salaryField;
	private final JButton cutButton;

	public EmployeeView(Controller controller) {
		this.controller = controller;
		frame = new JFrame();
		nameField = new JTextField();
		addressField = new JTextField();
		salaryField = new JTextField();
		cutButton = new JButton();
		init();
	}

	public void showEmployee(Employee employee) {
		frame.setTitle("Employee  \"" + employee.getPerson().getName() + "\"");
		nameField.setText(employee.getPerson().getName());
		addressField.setText(employee.getPerson().getAddress());
		salaryField.setText(Double.toString(employee.getSalary()));
		for (ActionListener al : cutButton.getActionListeners())
			cutButton.removeActionListener(al);
		cutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cutEmployeeClicked();

			}
		});
		frame.setVisible(true);
	}

	public void setVisibility(boolean v) {
		frame.setVisible(v);
	}

	public void init() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				controller.employeeClosed();
			}
		});
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "ESCAPE");
		frame.getRootPane().getActionMap().put("ESCAPE", new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.employeeClosed();
			}
		});
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		JPanel infoPanel = new JPanel(new GridLayout(4, 1, 30, 30));

		JPanel namePanel = new JPanel(new GridLayout(1, 2, 0, 10));
		JLabel nameLabel = new JLabel("Name:");
		namePanel.add(nameLabel);
		nameField.setColumns(10);
		namePanel.add(nameField);
		infoPanel.add(namePanel);

		JPanel addressPanel = new JPanel(new GridLayout(1, 2, 0, 0));
		JLabel addressLabel = new JLabel("Address:");
		addressPanel.add(addressLabel);
		addressPanel.add(addressField);
		addressField.setColumns(10);
		infoPanel.add(addressPanel);

		JPanel salaryPanel = new JPanel(new GridLayout(1, 2, 0, 0));
		JLabel salaryLabel = new JLabel("Salary:");
		salaryPanel.add(salaryLabel);
		salaryPanel.add(salaryField);
		salaryField.setColumns(10);
		cutButton.setText("Cut");
		infoPanel.add(salaryPanel);
		panel.add(infoPanel);

		JPanel cutPanel = new JPanel(new GridLayout(1, 1, 0, 0));
		cutPanel.add(cutButton);
		panel.add(cutPanel);
		cutPanel.setPreferredSize(new Dimension(110, 26));

		JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double newSalary = 0.0;
				try {
					newSalary = Double.valueOf(salaryField.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame,
							"Salary-entry is not a double value!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				controller.saveEmployeeClicked(nameField.getText(),
						addressField.getText(), newSalary);
			}
		});
		buttonPanel.add(saveButton);

		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double newSalary = 0.0;
				try {
					newSalary = Double.valueOf(salaryField.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame,
							"Salary-entry is not a double value!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				controller.okEmployeeClicked(nameField.getText(), addressField
						.getText(), newSalary);
			}
		});
		buttonPanel.add(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cancelEmployeeClicked();
			}
		});
		buttonPanel.add(cancelButton);

		panel.add(buttonPanel);

		frame.getContentPane().add(panel);
		frame.setSize(290, 350);
		frame.setLocation(200, 250);
		frame.setResizable(false);

	}
}
