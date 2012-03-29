package parseLib.parser;

import parseLib.acceptor.Acceptor;
import parseLib.util.Input;

/**
 * Convert an acceptor into a parser that constructs an int
 */
public class MkInteger extends Parser<Integer> {

	MkString p;
	
	public MkInteger(Acceptor p) {
		this.p = new MkString(p);
	}
	
	public Integer parse(Input i) {
		String s = p.parse(i);
		if (s==null)
			return null;
		else
			return Integer.parseInt(s.trim());
	}
}
