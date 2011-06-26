package javaf.syb;

import javaf.prelude.*;
import java.lang.reflect.*;
import java.util.List;

public class Query {

	/**
	 * Apply a type-specific function if possible; apply generic function otherwise.
	 */
	public static <X,Y> Function<Object,Y> or(final Function<X,Y> f, final Function<Object,Y> otherwise) {
		return new Function<Object,Y>() {

			@SuppressWarnings("unchecked")
			public Y apply(Object x) {
				try { 
					return f.apply((X)x);
				}
				catch (ClassCastException _) {
					return otherwise.apply(x);
				}				
			}
		};
	}
	
	/**
	 * Apply a function if possible; return default otherwise.
	 */
	public static <X,Y> Function<Object,Y> orDefault(final Function<X,Y> f, final Y otherwise) {
		return or(f, new Function<Object,Y>() { public Y apply(Object x) { return otherwise; }});
	}	
	
	/**
	 * Apply a query to all immediate sub-objects.
	 */
	public static <Y> Function<Object,Y> all(final Function<Object,Y> f, final BinaryOperator<Y> op, final Y initial) {
		return new Function<Object,Y>() {
			@SuppressWarnings("rawtypes")
			public Y apply(Object x) {
				Y y = initial;
				// Special case for lists
				if (x instanceof List)
					for (Object o : (List)x)
						y = op.apply(y, f.apply(o));
				else {
					// Regular case based on getters
					for (Method m : x.getClass().getDeclaredMethods()) {
						if (m.getName().startsWith("get") 
						&& m.getParameterTypes().length == 0) {
							try {
								y = op.apply(y, f.apply(m.invoke(x, new Object[]{})));
							}
							catch (IllegalAccessException e) {
								// assert "DEAD CODE"
							} catch (IllegalArgumentException e) {
								// assert "DEAD CODE"
							} catch (InvocationTargetException e) {
								// assert "DEAD CODE"
							}
						}
					}
				}
				return y;
			}			
		};					
	}
	
	/**
	 * Apply a function to each and every sub-object in bottom-up manner.
	 */
	public static <Y> Function<Object,Y> everything(final Function<Object,Y> f, final BinaryOperator<Y> op, final Y initial) {
		return new Function<Object,Y>() {
			public Y apply(Object x) {
				return op.apply(f.apply(x), all(everything(f, op, initial), op, initial).apply(x));
			}
		};
	}
}
