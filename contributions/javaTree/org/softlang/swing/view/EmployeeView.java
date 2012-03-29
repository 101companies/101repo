package org.softlang.swing.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.softlang.company.Employee;
import org.softlang.swing.model.Model;

/**
 * This class provides the gui for employee information and employee changes.
 * 
 * @author Tobias Zimmer, Eduard Ditler, Hanna-Marike Reger, Helena Swerdlow,
 *         Jan Ruether
 */
public class EmployeeView extends AbstractView {

	/** automatically generated serialVersionUID */
	private static final long serialVersionUID = 6904484189795643748L;

	private JTextField address;

	/**
	 * Constructor.
	 * 
	 * @param model
	 */
	public EmployeeView(Model model) {
		super(model);

		address = new JTextField();

		createView();
	}

	/*
	 * create GUI components 
	 */
	private void createView() {
		Employee employee = (Employee) model.getCurrentValue();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// name
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 10, 0, 0);
		c.anchor = GridBagConstraints.WEST;

		this.add(new JLabel("Name: "), c);

		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		name.setText(employee.getName());
		this.add(name, c);

		// address
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		c.weightx = 0;
		this.add(new JLabel("Address: "), c);

		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		address.setText(employee.getAddress());
		this.add(address, c);

		// salary
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		c.weightx = 0;
		this.add(new JLabel("Salary: "), c);

		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		total.setText(model.getTotal());
		this.add(total, c);

		// cut
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 2;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		this.add(cut, c);

		// filler
		c.gridy = 4;
		c.weighty = 1;
		c.fill = GridBagConstraints.VERTICAL;
		this.add(new JPanel(), c);
	}

	/**
	 * This method adds the listener for the address field of the current
	 * employee view.
	 * 
	 * @param change listener
	 */
	public void addAddressListener(KeyListener listener) {
		address.addKeyListener(listener);
	}

	/**
	 * This method adds the listener for the salary field of the current
	 * employee view.
	 * 
	 * @param change listener
	 */
	public void addSalaryListener(KeyListener listener) {
		total.addKeyListener(listener);
	}
}
