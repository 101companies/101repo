package javaf.prelude;

/**
 * An action has an argument but no result.
 * Multiple arguments could be grouped if needed.
 */
public interface Action<X> {
	void apply(X x);
}
