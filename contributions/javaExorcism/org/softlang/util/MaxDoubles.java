package org.softlang.util;

/**
 * A monoid for max
 */
public final class MaxDoubles implements Monoid<Double> {
	private static MaxDoubles instance = null;
	private MaxDoubles() { }
	public static MaxDoubles getInstance() {
		if(instance == null)
			instance = new MaxDoubles();
		return instance;
	}
	public Double unit() { return null; }
	public Double append(Double x, Double y) {
		if (x==null) return y;
		if (y==null) return x;
		return Math.max(x,y); 
	}
}
