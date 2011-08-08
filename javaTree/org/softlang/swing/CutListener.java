package org.softlang.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.operations.Cut;

/*
 * Der Listener wird aufgerufen wenn ein "Cut-Button" gedrückt wird.
 * Daraufhin ruft der Listener die Cut Methode auf dem ihm zugehörigen Objekt auf.
 */
public class CutListener implements ActionListener {

	private String objectType;
	private Object object;
	private TotalView view;

	public CutListener(Object userObject, String objectType, TotalView view) {
		this.object = userObject;
		this.objectType = objectType;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (objectType.equals("company")) {
			Cut.cut((Company) object);
			view.setView((Company) object);
		} else if (objectType.equals("department")) {
			Cut.cut((Department) object);
			view.setView((Department) object);
		} else if (objectType.equals("employee")) {
			Cut.cut((Employee) object);
			view.setView((Employee) object);
		}
	}

}
