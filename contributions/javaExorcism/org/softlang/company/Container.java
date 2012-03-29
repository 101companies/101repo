package org.softlang.company;

/**
 * An interface for all composites in an company object structure.
 * Containers are supposed to aggregate sub-units.
 */
public interface Container extends Component {
	Iterable<? extends Subunit> subunits();
	boolean add(Subunit u);
	boolean remove(Subunit u);
}
