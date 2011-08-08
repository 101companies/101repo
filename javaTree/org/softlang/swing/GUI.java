package org.softlang.swing;

import org.softlang.company.Company;

/**
 * Initialisierung der GUI und des Controllers
 * 
 */
public class GUI {

	public GUI(Company c) {
		Controller controller = new Controller(c);
		TotalView view = new TotalView(controller);
		controller.setView(view);
	}
}