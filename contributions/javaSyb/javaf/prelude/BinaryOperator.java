package javaf.prelude;

/**
 * This is essentially a binary operator, say a function with two arguments where argument types and result type coincide.
 */
public interface BinaryOperator<X> {
	X apply(X x1, X x2);
}
