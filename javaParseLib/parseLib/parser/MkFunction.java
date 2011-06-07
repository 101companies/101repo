package parseLib.parser;

import parseLib.util.Input;
import javaf.prelude.Function1;

/**
 * A parser transformer to apply function parser result
 */
public class MkFunction<X,Y> extends Parser<Y> {

	private Parser<X> p;
	private Function1<X,Y> f;

	public MkFunction(Parser<X> p, Function1<X,Y> f) {
		this.p = p; 
		this.f = f; 
	}
	
	public Y parse(Input i) {
		X x = p.parse(i);
		if (x==null) 
			return null;
		else
			return f.apply(x);
	}
}
