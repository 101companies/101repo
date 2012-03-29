package org.softlang.company;

/**
 * A department has a name, employees, and sub-departments.
 * One of the employees is supposed to be the manager.
 * We add a getter for the manager for convenience's sake.
 */
public interface Department extends Subunit, Container {
	Employee getManager();
}
