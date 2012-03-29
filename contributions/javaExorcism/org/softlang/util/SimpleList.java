package org.softlang.util;

/**
 * This is a down-graded version of java.util.List.
 */
public interface SimpleList<X> extends Iterable<X> {
	boolean add(X x);
	boolean remove(X x);
}
