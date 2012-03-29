package org.softlang.features;

/**
 * In fact, all classes of the object model end up implementing 
 * these operations. See the aspect Polymorphism.aj for the
 * incorporation of the interface into the original classes.
 */
public interface Operations {
	String getName();
	double total();
	void cut();
}
