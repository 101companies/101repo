package parseLib.acceptor;

import parseLib.util.Input;

/**
 * An acceptor that must fail.
 * The resulting acceptor has no affect on the input no matter what.
 */
public class Not extends Acceptor {

	private Acceptor a;
	
	public Not(Acceptor a) {
		this.a = a;
	}
	
	public boolean accept(Input i) {
		int mark = i.getPos();
		boolean status = a.accept(i);
		i.setPos(mark);
		return !status;
	}

}
