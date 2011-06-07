package parseLib.parser;

import parseLib.acceptor.Acceptor;
import parseLib.util.Input;

/**
 * Compose an acceptor followed by a parser
 */
public class MkSnd<T> extends Parser<T> {
	
	private Acceptor left;
	private Parser<T> right;
	
	public MkSnd(Acceptor left, Parser<T> right) {
		this.left = left;
		this.right = right;
	}
	
	public T parse(Input i) {
		if (!left.accept(i))
			return null;
		return right.parse(i);
	};
}
