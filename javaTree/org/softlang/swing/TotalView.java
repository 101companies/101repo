package org.softlang.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.operations.Total;

/**
 * Diese Klasse ist die Anzeige unseres Programms. Sie ist unterteilt in eine
 * Baumansicht der Objekte auf der linken Seite. Auf der rechten Seite wird ein
 * aktuell, im Baum, angewähltes Objekt angezeigt.
 * 
 */
public class TotalView extends JFrame {

	/** automatically generated serialVersionUID */
	private static final long serialVersionUID = 8746893760284562164L;
	
	private final Controller controller;
	private final JFrame frame;
	private JPanel view;
	private DefaultMutableTreeNode root;

	public TotalView(Controller c) {
		frame = new JFrame();
		view = new JPanel(new GridBagLayout());
		controller = c;
		init();
	}

	/**
	 * Initialisiert die Hauptkomponeten der GUI
	 */
	private void init() {
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(5, 5, 5, 5);
		
		GridLayout layout = new GridLayout(1, 2);
		JPanel inner = new JPanel(layout);
		frame.add(inner, c);
		
		inner.add(createTree());
		inner.add(view);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(new Dimension(800, 600));
		frame.setLocation(0, 25);
		frame.setResizable(true);
		frame.setTitle("101implementation:Swing");
		frame.setVisible(true);
	}

	/**
	 * Initialisiert den Baum aus der Company
	 */
	private Component createTree() {

		Company company = controller.getCompany();

		// create Tree for company
		root = new DefaultMutableTreeNode(company);
		company.setTreeNode(root);

		for (Department d : company.getDepts()) {
			root.add(addDepartmentNode(d));
		}

		JTree tree = new JTree(root);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent event) {
				// find sender
				TreePath path = event.getNewLeadSelectionPath();
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path
						.getLastPathComponent();

				if (selectedNode.getUserObject().getClass().equals(
						Company.class)) {
					setView((Company) selectedNode.getUserObject());
				} else if (selectedNode.getUserObject().getClass().equals(
						Department.class)) {
					setView((Department) selectedNode.getUserObject());
				} else if (selectedNode.getUserObject().getClass().equals(
						Employee.class)) {
					setView((Employee) selectedNode.getUserObject());
				}
			}
		});

		return new JScrollPane(tree);
	}

	/**
	 * Setzt die rechte Seite auf die Ansicht für das übergebene Employee Objekt
	 */
	protected void setView(Employee userObject) {
		controller.setRightView(userObject);
		
		view.setVisible(false);
		view.removeAll();
		
		GridBagConstraints c = new GridBagConstraints();
		
		// name
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 10, 0, 0);
		c.anchor = GridBagConstraints.WEST;
			
		view.add(new JLabel("Name: "), c);
		
		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		JTextField name = new JTextField(userObject.getName(), 10);
		name.addKeyListener(new ChangeListener(controller, "name"));
		view.add(name, c);

		// address
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		c.weightx = 0;
		view.add(new JLabel("Address: "), c);
		
		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		JTextField address = new JTextField(userObject.getAddress(), 10);
		address.addKeyListener(new ChangeListener(controller, "address"));
		view.add(address, c);

		// salary
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		c.weightx = 0;
		view.add(new JLabel("Salary: "), c);
		
		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		JTextField salary = new JTextField(Double.toString(userObject
				.getSalary()), 10);
		salary.addKeyListener(new ChangeListener(controller, "salary"));
		view.add(salary, c);

		// cut
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 2;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		JButton cut = new JButton("cut");
		cut.addActionListener(new CutListener(userObject, "employee",
				this));
		view.add(cut, c);
		
		// filler
		c.gridy = 4;
		c.weighty = 1;
		c.fill = GridBagConstraints.VERTICAL;
		view.add(new JPanel(), c);
		
		view.repaint();
		view.setVisible(true);

	}

	/**
	 * Setzt die rechte Seite auf die Ansicht für das übergebene Department
	 * Objekt
	 */
	protected void setView(Department userObject) {
		controller.setRightView(userObject);
		
		view.setVisible(false);
		view.removeAll();
		
		GridBagConstraints c = new GridBagConstraints();
		
		// name
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 10, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		view.add(new JLabel("Name: "), c);
		
		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		JTextField name = new JTextField(userObject.getName());
		name.addKeyListener(new ChangeListener(controller, "name"));
		view.add(name, c);
		
		// total
		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		view.add(new JLabel("Total: "), c);
		
		c.gridx = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;		
		JTextField total = new JTextField(Double.toString(Total.total(userObject)));
		total.setEditable(false);		
		view.add(total, c);
		
		// cut
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		JButton cut = new JButton("cut");
		cut.addActionListener(new CutListener(userObject, "department",
				this));

		view.add(cut, c);
		
		// filler
		c.gridy = 3;
		c.weighty = 1;
		c.fill = GridBagConstraints.VERTICAL;
		view.add(new JPanel(), c);
		
		view.repaint();
		view.setVisible(true);
	}

	/**
	 * Setzt die rechte Seite auf die Ansicht für das übergebene Company Objekt
	 */
	protected void setView(Company userObject) {
		controller.setRightView(userObject);
		
		view.setVisible(false);
		view.removeAll();
		
		GridBagConstraints c = new GridBagConstraints();
		
		// name
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 10, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		view.add(new JLabel("Name: "), c);
		
		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		JTextField name = new JTextField(userObject.getName());
		name.addKeyListener(new ChangeListener(controller, "name"));
		view.add(name, c);
		
		// total
		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		view.add(new JLabel("Total: "), c);
		
		c.gridx = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;		
		JTextField total = new JTextField(Double.toString(Total.total(userObject)));
		total.setEditable(false);		
		view.add(total, c);
		
		// cut
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		JButton cut = new JButton("cut");
		cut.addActionListener(new CutListener(userObject, "company",
				this));
		view.add(cut, c);
		
		// filler
		c.gridy = 3;
		c.weighty = 1;
		c.fill = GridBagConstraints.VERTICAL;
		view.add(new JPanel(), c);
		
		view.repaint();
		view.setVisible(true);

	}

	/**
	 * Hilfsfunktion für die Baum Erstellung welche aus einem Department
	 * Baumtypische Knoten macht
	 */
	private MutableTreeNode addDepartmentNode(Department dep) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(dep);
		dep.setTreeNode(root);
		root.add(addManagerNode(dep.getManager()));
		for (Department d : dep.getSubdepts()) {
			root.add(addDepartmentNode(d));
		}
		for (Employee e : dep.getEmployees()) {
			root.add(addEmployeeNode(e));
		}
		return root;
	}

	/**
	 * Hilfsfunktion für die Baum Erstellung welche aus einem Employee
	 * Baumtypische Knoten macht
	 */
	private MutableTreeNode addEmployeeNode(Employee e) {
		DefaultMutableTreeNode employee = new DefaultMutableTreeNode(e);
//		e.setTreeNode(employee);
//		DefaultMutableTreeNode address = new DefaultMutableTreeNode("Address: "
//				+ e.getAddress());
//		DefaultMutableTreeNode salary = new DefaultMutableTreeNode("Salary: "
//				+ e.getSalary());
//		employee.add(address);
//		employee.add(salary);
		return employee;
	}

	/**
	 * Hilfsfunktion für die Baum Erstellung welche aus einem Employee, vom Typ
	 * Manager, Baumtypische Knoten macht
	 */
	private MutableTreeNode addManagerNode(Employee m) {
		m.setManager(true);
		DefaultMutableTreeNode manager = new DefaultMutableTreeNode(m);
//		m.setTreeNode(manager);
//		DefaultMutableTreeNode address = new DefaultMutableTreeNode("Address: "
//				+ m.getAddress());
//		DefaultMutableTreeNode salary = new DefaultMutableTreeNode("Salary: "
//				+ m.getSalary());
//		DefaultMutableTreeNode isManager = new DefaultMutableTreeNode("Manager");
//		manager.add(address);
//		manager.add(salary);
//		manager.add(isManager);
		return manager;
	}
}
