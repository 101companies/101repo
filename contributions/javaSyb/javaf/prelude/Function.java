package javaf.prelude;

/**
 * A function has an argument and a result.
 * Multiple arguments could be grouped if needed.
 */
public interface Function<X,Y> {
	Y apply(X x);
}
