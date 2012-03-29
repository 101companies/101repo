package parseLib.acceptor;

import parseLib.util.Input;

/**
 * A parser for alternative constructs
 */
public class Choice extends Acceptor {

	Acceptor[] as;
	
	public Choice(Acceptor... as) {
		this.as = as;
	}

	public boolean accept(Input i) {
		int mark = i.getPos();
		for (int j=0; j<as.length; j++) {
			i.setPos(mark);
			if (as[j].accept(i))
				return true;
		}
		return false;
	}
}
