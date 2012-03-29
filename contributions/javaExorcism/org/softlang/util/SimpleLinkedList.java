package org.softlang.util;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This is a down-graded version of java.util.LinkedList.
 */
public class SimpleLinkedList<X> implements SimpleList<X> {

	protected LinkedList<X> inner = 
		new LinkedList<X>();
		
	public Iterator<X> iterator() {
		return inner.iterator();
	}

	public boolean add(X x) {
		return inner.add(x);
	}

	public boolean remove(X x) {
		return inner.remove(x);
	}
}
