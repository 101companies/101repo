package org.softlang.command;

public class Command {
	
	private boolean done = false;

	public void execute() {
		if (done)
			throw new IllegalArgumentException();
		done = true;
	}
	public void undo() {
		if (!done)
			throw new IllegalArgumentException();		
		done = false;
	}
}
