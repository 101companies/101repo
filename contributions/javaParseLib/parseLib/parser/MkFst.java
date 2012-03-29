package parseLib.parser;

import parseLib.acceptor.Acceptor;
import parseLib.util.Input;

/**
 * Compose a parser followed by an acceptor
 */
public class MkFst<T> extends Parser<T> {
	
	private Parser<T> left;
	private Acceptor right;
	
	public MkFst(Parser<T> left, Acceptor right) {
		this.left = left;
		this.right = right;
	}
	
	public T parse(Input i) {
		T t = left.parse(i);
		if (t==null)
			return null;
		if (!right.accept(i))
			return null;
		return t;
	};
}
