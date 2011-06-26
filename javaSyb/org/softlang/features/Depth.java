package org.softlang.features;

import org.softlang.company.*;
import javaf.prelude.*;
import static javaf.syb.Query.*;

/**
 * Compute department nesting depth in a robust manner.
 * The implementation does not make any assumptions other than that there are objects of type Department
 */
public class Depth {

	public static int depth(Company c) {
		return traverse().apply(c);
	}
	
	public static Function<Object,Integer> traverse() {
		return new Function<Object,Integer>() {
			public Integer apply(Object x) {
				final int result = all(traverse(), max, 0).apply(x);
				return orDefault(
						new Function<Department,Integer>() {
							public Integer apply(Department x) {
								return result+1;
							}
						},
						result).apply(x);
			}
		};
	}
	
	public static BinaryOperator<Integer> max =
		new BinaryOperator<Integer>() {
			public Integer apply(Integer x1, Integer x2) {
				return Math.max(x1,x2);
			}
		};		
}
