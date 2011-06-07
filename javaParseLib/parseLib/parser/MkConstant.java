package parseLib.parser;

import parseLib.acceptor.Acceptor;
import parseLib.util.Input;

/**
 * Convert an acceptor into a parser that constructs an int
 */
public class MkConstant<T> extends Parser<T> {

	Acceptor a;
	T t;
	
	public MkConstant(Acceptor a, T t) {
		this.a = a;
		this.t = t;
	}
	
	public T parse(Input i) {
		if (!a.accept(i)) 
			return null;
		return t;
	}
}
