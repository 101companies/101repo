package parseLib.parser;

import parseLib.util.Input;
import java.util.List;
import java.util.LinkedList;

/**
 * A parser for iterated constructs (0,1 or more occurrences)
 */
public class MkStar<T> extends Parser<List<T>> {

	private Parser<T> p;

	public MkStar(Parser<T> p) {
		this.p = p; 
	}
	
	public List<T> parse(Input i) {
		List<T> r = new LinkedList<T>();
		while (true) {
			int mark = i.getPos();
			T t = p.parse(i);
			if (t!=null)
				r.add(t);
			else {
				i.setPos(mark);
				return r;
			}
		}		
	}
}
