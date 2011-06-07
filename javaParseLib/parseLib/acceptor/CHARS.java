package parseLib.acceptor;

import parseLib.util.Input;

/**
 * A parser for a string
 */
public class CHARS extends Acceptor {

	String[] ss;
	
	public CHARS(String s) {
		this.ss = new String[] { s };
	}

	public CHARS(String[] ss) {
		this.ss = ss;
	}	
	
	public boolean accept(Input i) {
		int mark = i.getPos();
		l1: 
			for (String s : ss)	{
				i.setPos(mark);
				for (int j=0; j<s.length(); j++) {
					char c = (char) i.read();
					if (c == 0 || c != s.charAt(j))
						continue l1;
				}
				return true;
			}
			return false;
	}
}
