package org.softlang.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * Dient dazu um Änderungen im rechten Panel an den Controller weiterzuleiten.
 * Es wird der neue Wert an den Controller geschickt.
 * 
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
		nameChanged(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		nameChanged(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		nameChanged(e);
	}

	private void nameChanged(KeyEvent e) {
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
