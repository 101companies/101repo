package javaf.syb;

import javaf.prelude.*;
import java.lang.reflect.*;
import java.util.List;

public class Transformation {

	/**
	 * Apply an action if possible.
	 */
	public static <X> Action<Object> orIdentity(final Action<X> a) {
		return new Action<Object>() {
			
			@SuppressWarnings("unchecked")
			public void apply(Object x) {
				try { 
					a.apply((X)x);
				}
				catch (ClassCastException _) {
					// Do nothing
				}				
			}
		};
	}
	
	/**
	 * Apply a transformation to all immediate sub-objects.
	 */
	public static Action<Object> all(final Action<Object> a) {
		return new Action<Object>() {
			@SuppressWarnings("rawtypes")
			public void apply(Object x) {
				// Special case for lists
				if (x instanceof List)
					for (Object o : (List)x)
						a.apply(o);
				else {
					// Regular case based on getters
					for (Method m : x.getClass().getDeclaredMethods()) {
						if (m.getName().startsWith("get") 
						&& m.getParameterTypes().length == 0) {
							try {
								a.apply(m.invoke(x, new Object[]{}));
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
			}			
		};							
	}
	
	/**
	 * Apply a function to each and every sub-object in bottom-up manner.
	 */
	public static Action<Object> everywhere(final Action<Object> a) {		
		return new Action<Object>() {
			public void apply(Object x) {
				all(everywhere(a)).apply(x);
				a.apply(x);
			}
		};
	}
}
