package org.softlang.swing.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.softlang.company.Department;
import org.softlang.swing.model.Model;

/**
 * This class provides the gui for department information and department changes.
 * 
 * @author Tobias Zimmer, Eduard Ditler, Hanna-Marike Reger, Helena Swerdlow,
 *         Jan Ruether
 */
public class DepartmentView extends AbstractView {
	
	/** automatically generated serialVersionUID */
	private static final long serialVersionUID = 6814479671011781474L;
	
	/**
	 * Constructor.
	 * 
	 * @param model
	 */
	public DepartmentView(Model model) {
		super(model);
		createView();
	}
	
	/*
	 * create GUI components 
	 */
	private void createView() {
		Department department = (Department) model.getCurrentValue();
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
		name.setText(department.getName());
		this.add(name, c);
		
		// total
		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Total: "), c);
		
		c.gridx = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;		
		total.setText(model.getTotal());
		total.setEditable(false);		
		this.add(total, c);
		
		// cut
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;

		this.add(cut, c);
		
		// filler
		c.gridy = 3;
		c.weighty = 1;
		c.fill = GridBagConstraints.VERTICAL;
		this.add(new JPanel(), c);
	}
}
