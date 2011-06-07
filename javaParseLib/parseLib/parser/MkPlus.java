package parseLib.parser;

import parseLib.util.Input;
import java.util.List;
import java.util.LinkedList;

/**
 * A parser for iterated constructs (1 or more occurrences)
 */
public class MkPlus<T> extends Parser<List<T>> {

	private Parser<T> p;

	public MkPlus(Parser<T> p) {
		this.p = p; 
	}
	
	public List<T> parse(Input i) {
		List<T> r = new LinkedList<T>();
		T t = p.parse(i);
		if (t==null)
			return null;
		else
			r.add(t);
		while (true) {
			int mark = i.getPos();
			t = p.parse(i);
			if (t!=null)
				r.add(t);
			else {
				i.setPos(mark);
				return r;
			}
		}		
	}
}
