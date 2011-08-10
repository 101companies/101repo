package org.softlang.swing.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * This class manages the changes of the textfields of the active view.
 * 
 * @author Eduard Ditler, Hanna-Marike Reger, Helena Swerdlow, Jan Ruether
 */
public class ChangeListener implements KeyListener {

	private Controller controller;
	private String subject;

	public ChangeListener(Controller controller, String subject) {
		this.controller = controller;
		this.subject = subject;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		valueChanged(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// stub
	}

	private void valueChanged(KeyEvent e) {
		JTextField n = (JTextField) e.getComponent();
		if (subject.equals("address")) {
			controller.addressChanged(n.getText());
		} else if (subject.equals("name")) {
			controller.nameChanged(n.getText());
		} else if (subject.equals("salary")) {
			controller.salaryChanged(n.getText());
		}
	}
}
