package org.softlang.company.impl.bean;

import org.softlang.company.*;
import org.softlang.util.ObservableSimpleList;
import org.softlang.util.SimpleLinkedList;
import java.util.Observer;

public abstract class ContainerImpl extends ComponentImpl implements Container {

	private ObservableSimpleList<Subunit> subunits = 
		new ObservableSimpleList<Subunit>(
				new SimpleLinkedList<Subunit>());
	
	public Iterable<? extends Subunit> subunits() {
		return subunits;
	}

	public boolean add(Subunit u) {
		ComponentImpl i = (ComponentImpl)u;
		if (i.getParent()!=null)
			throw new IllegalArgumentException("Attemped re-parenting.");
		i.setParent(this);
		return subunits.add(u);
	}

	public boolean remove(Subunit u) {
		ComponentImpl i = (ComponentImpl)u;
		i.setParent(null);
		return subunits.remove(u);
	}
	
	public void addObserver(Observer o) {
		super.addObserver(o);
		subunits.addObserver(o);
	}
	
	public void deleteObserver(Observer o) {
		super.deleteObserver(o);
		subunits.deleteObserver(o);		
	}
	
	public void deleteObservers() {
		super.deleteObservers();
		subunits.deleteObservers();
	}			
}
