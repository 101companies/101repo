package parseLib.parser;

import parseLib.util.Input;

/**
 * A parser for alternative constructs
 */
public class MkChoice<T> extends Parser<T> {

	Parser<T>[] ps;
	
	public MkChoice(Parser<T>... ps) {
		this.ps = ps;
	}

	public T parse(Input i) {
		int mark = i.getPos();
		for (int j=0; j<ps.length; j++) {
			i.setPos(mark);
			T t = ps[j].parse(i); 
			if (t!=null)
				return t;
		}
		return null;
	}
}
