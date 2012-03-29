package parseLib.parser;

import parseLib.util.*;

/**
 * Combine sequential parsers in a triplet
 */
public class MkTuple3<T1,T2,T3> extends Parser<Tuple3<T1,T2,T3>> {
	
	Parser<T1> p1;
	Parser<T2> p2;
	Parser<T3> p3;

	public MkTuple3(Parser<T1> p1, Parser<T2> p2, Parser<T3> p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public Tuple3<T1,T2,T3> parse(Input i) {
		T1 t1 = p1.parse(i);
		if (t1==null) 
			return null;
		T2 t2 = p2.parse(i);
		if (t2==null) 
			return null;
		T3 t3 = p3.parse(i);
		if (t3==null) 
			return null;
		return new Tuple3<T1,T2,T3>(t1, t2, t3);
	};
}
