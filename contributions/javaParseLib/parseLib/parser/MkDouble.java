package parseLib.parser;

import parseLib.acceptor.Acceptor;
import parseLib.util.Input;

/**
 * Convert an acceptor into a parser that constructs a double
 */
public class MkDouble extends Parser<Double> {

	MkString p;
	
	public MkDouble(Acceptor p) {
		this.p = new MkString(p);
	}
	
	public Double parse(Input i) {
		String s = p.parse(i);
		if (s==null)
			return null;
		else
			return Double.parseDouble(s.trim());
	}
}
