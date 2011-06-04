package org.softlang.command;

import java.util.List;
import java.util.LinkedList;
import static java.util.Collections.*;

/**
 * Aggregate many commands.
 */
public class Batch extends Command {
		
	private List<Command> commands =
		new LinkedList<Command>();
	
	public void add(Command c) {
		commands.add(c);
	}
	
	public void execute() {
		super.execute();		
		for (Command c : commands)
			c.execute();
	}
	
	public void undo() { 
		super.undo();
		reverse(commands);
		for (Command c : commands)
			c.undo();		
		reverse(commands);
	}
}
