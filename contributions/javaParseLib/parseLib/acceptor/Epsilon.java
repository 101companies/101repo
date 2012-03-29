package parseLib.acceptor;

import parseLib.util.Input;

/**
 * The parser for the language of the empty string
 */
public class Epsilon extends Acceptor {

	public boolean accept(Input i) {
		return true;
	}
}
