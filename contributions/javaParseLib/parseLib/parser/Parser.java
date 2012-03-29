package parseLib.parser;

import javaf.prelude.Function1;
import parseLib.acceptor.Acceptor;
import parseLib.util.*;
import java.util.List;

/**
 * The base class of all parser combinators (classes)
 */
public abstract class Parser<T> {

	/** 
	 * The essential method of a parser combinator 
	 */
	public abstract T parse(Input i);

	//
	//
	// The following methods provide convenience of parser combination.
	//
	//
	
	public static <X> Parser<X> mkFst(Parser<X> p, Acceptor a) {
		return new MkFst<X>(p, a);
	}

	public static <X> Parser<X> mkSnd(Acceptor a, Parser<X> p) {
		return new MkSnd<X>(a, p);
	}
	
	public static <X,Y> Parser<Tuple2<X,Y>> mkTuple2(Parser<X> px, Parser<Y> py) {
		return new MkTuple2<X,Y>(px, py);
	}
	
	public static <X,Y,Z> Parser<Tuple3<X,Y,Z>> mkTuple3(Parser<X> px, Parser<Y> py, Parser<Z> pz) {
		return new MkTuple3<X,Y,Z>(px, py, pz);
	}	
	
	public static <X,Y> Parser<Y> mkFunction(Parser<X> p, Function1<X,Y> f) {
		return new MkFunction<X,Y>(p, f);
	}		
	
	public static <X> Parser<List<X>> mkStar(Parser<X> p) {
		return new MkStar<X>(p);
	}			
}
