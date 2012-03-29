package parseLib.acceptor;

import parseLib.util.Input;

/**
 * A parser for sequentially composed constructs
 */
public class Sequence extends Acceptor {

	Acceptor[] ps;
	
	public Sequence(Acceptor... ps) {
		this.ps = ps;
	}
	
	public boolean accept(Input i) {
		for (int j=0; j<ps.length; j++) {
			if (!ps[j].accept(i))
				return false;
		}
		return true;
	}
}
