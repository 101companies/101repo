package parseLib.acceptor;

import parseLib.util.Input;

/**
 * A parser for iterated constructs (1 or more occurrences)
 */
public class Plus extends Acceptor {

	private Acceptor a;

	public Plus(Acceptor p) { 
		this.a = p;
	}
	
	public boolean accept(Input i) {
		if (!a.accept(i))
			return false;
		while (true) {
			int mark = i.getPos();
			if (!a.accept(i)) {
				i.setPos(mark);
				return true;
			}
		}		
	}
}
