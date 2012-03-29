package org.softlang.util;

/**
 * A monoid for addition
 */
public final class AddDoubles implements Monoid<Double> {
	private static AddDoubles instance = null;
	private AddDoubles() { }
	public static AddDoubles getInstance() {
		if(instance == null)
			instance = new AddDoubles();
		return instance;
	}
	public Double unit() { return 0.0; }
	public Double append(Double x, Double y) { return x+y; }
}
