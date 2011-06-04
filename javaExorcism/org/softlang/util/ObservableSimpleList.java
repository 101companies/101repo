package org.softlang.util;

import java.util.*;

/**
 * Compose the (Simple)List interface with the Observable base class.
 * In fact, a given list is decorated with observer capability.
 * The methods must be adjusted to notify upon changes.
 * Addition and removal of observers is pushed into elements--if they are observable.
 */
public class ObservableSimpleList<X> extends Observable implements SimpleList<X> {

	private SimpleList<X> inner;
	
	public ObservableSimpleList(SimpleList<X> inner) {
		this.inner = inner;
	}
		
	//
	//
	// Methods of the Observable interface are overridden. 
	//
	//
	
	public void addObserver(Observer o) {
		super.addObserver(o);
		for (X e : this)
			if (e instanceof Observable)
				((Observable)e).addObserver(o);
	}
	
	public void deleteObserver(Observer o) {
		super.deleteObserver(o);
		for (X e : this)
			if (e instanceof Observable)
				((Observable)e).deleteObserver(o);
	}
	
	public void deleteObservers() {
		super.deleteObservers();
		for (X e : this)
			if (e instanceof Observable)
				((Observable)e).deleteObservers();
	}	
		
	//
	//
	// Beyond this point, the SimpleList interface is implemented
	//
	//
	
	public Iterator<X> iterator() {
		return inner.iterator();
	}
		
	public boolean add(X e) {
		boolean result = inner.add(e);
		if (result) {
			setChanged();
			notifyObservers(new AddToList(e));	
		}
		return result;
	}

	public boolean remove(X e) {
		boolean result = inner.remove(e);
		if (result) {
			setChanged();
			notifyObservers(new RemoveFromList(e));
		}
		return result;
	}
}
