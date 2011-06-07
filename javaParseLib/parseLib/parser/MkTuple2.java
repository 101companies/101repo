package parseLib.parser;

import parseLib.util.*;

/**
 * Combine two sequential parsers in a pair
 */
public class MkTuple2<T1,T2> extends Parser<Tuple2<T1,T2>> {
	
	Parser<T1> p1;
	Parser<T2> p2;

	public MkTuple2(Parser<T1> p1, Parser<T2> p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Tuple2<T1,T2> parse(Input i) {
		T1 t1 = p1.parse(i);
		if (t1==null) 
			return null;
		T2 t2 = p2.parse(i);
		if (t2==null) 
			return null;
		return new Tuple2<T1,T2>(t1, t2);
	};
}
