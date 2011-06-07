package parseLib.parser;

import parseLib.acceptor.Acceptor;
import parseLib.util.Input;

/**
 * Convert an acceptor into a parser that constructs a string
 */
public class MkString extends Parser<String> {

	Acceptor p;
	
	public MkString(Acceptor p) {
		this.p = p;
	}
	
	public String parse(Input i) {
		int begin = i.getPos();
		if (!p.accept(i))
			return null;
		else
			return i.substring(begin, i.getPos()).trim();
	}
}
