package parseLib.acceptor;

import parseLib.util.Input;

/**
 * A parser for optional constructs 
 */
public class Optional extends Acceptor {

	private Acceptor a;
	
	public Optional(Acceptor a) {
		this.a = a;
	}
	
	public boolean accept(Input i) {
		int mark = i.getPos();
		if (!a.accept(i))
			i.setPos(mark);
		return true;
	}
}
