package parseLib.acceptor;

import parseLib.util.Input;

/**
 * A parser for iterated constructs (0,1 or more occurrences)
 */
public class Star extends Acceptor {

	private Acceptor a;

	public Star(Acceptor a) { this.a = a; }
	
	public boolean accept(Input i) {
		while (true) {
			int mark = i.getPos();
			if (!a.accept(i)) {
				i.setPos(mark);
				return true;
			}
		}		
	}
}
