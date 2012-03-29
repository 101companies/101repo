package javaf.prelude;

/** Functions with two arguments **/
public interface Function2<X1,X2,Y> {
	Y apply(X1 x1, X2 x2);
}
