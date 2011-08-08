package org.softlang.swing;

import org.softlang.company.*;

import static org.softlang.operations.Total.*;
import static org.softlang.operations.Cut.*;
import java.util.Stack;

/**
 * Der Controller verbindet die Company mit der View. Die Listener gehören zum
 * Controller, aus der Sicht der MVC Aufteilung.
 * 
 */
public class Controller {

	private TotalView view;

	private Company company;
	// aktuell auf der RechtenGUI Seite betrachtetes Objekt.
	private Object actualVisited;

	public Controller(Company company) {
		this.company = company;
	}

	public void setView(TotalView view) {
		this.view = view;
	}

	public void setRightView(Object o) {
		actualVisited = o;
	}

	Company getCompany() {
		return company;
	}

	/**
	 * Die Methode wird aufgerufen wenn auf der Rechten Seite der Name eines
	 * Objekts geändert wird.
	 * 
	 * @param text
	 *            neuer Wert
	 */
	public void nameChanged(String text) {
		if (actualVisited.getClass().equals(Company.class)) {
			Company c = (Company) actualVisited;
			c.setName(text);
		} else if (actualVisited.getClass().equals(Department.class)) {
			Department d = (Department) actualVisited;
			d.setName(text);
		} else if (actualVisited.getClass().equals(Employee.class)) {
			Employee e = (Employee) actualVisited;
			e.setName(text);
		}
	}

	/**
	 * Die Methode wird aufgerufen wenn auf der Rechten Seite der Salary-Wert
	 * eines Objekts geändert wird.
	 * 
	 * @param text
	 *            neuer Wert
	 */
	public void salaryChanged(String text) {
		Employee e = (Employee) actualVisited;
		e.setSalary(Double.parseDouble(text));

	}

	/**
	 * Die Methode wird aufgerufen wenn auf der Rechten Seite die Adresse eines
	 * Objekts geändert wird.
	 * 
	 * @param text
	 *            neuer Wert
	 */
	public void addressChanged(String text) {
		Employee e = (Employee) actualVisited;
		e.setAddress(text);

	}
}
