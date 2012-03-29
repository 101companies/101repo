package parseLib.parser;

import parseLib.util.Input;

import java.util.*;

/**
 * A parser for optional constructs 
 */
public class MkOptional<T> extends Parser<List<T>> {
	
	Parser<T> p;
	
	public MkOptional(Parser<T> p) {
		this.p = p;
	}
	
	public List<T> parse(Input i) {
		List<T> r = new LinkedList<T>();
		int mark = i.getPos();
		T t = p.parse(i);
		if (t==null)
			i.setPos(mark);
		else
			r.add(t);
		return r;
	}
}
