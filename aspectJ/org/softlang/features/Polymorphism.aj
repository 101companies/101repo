package org.softlang.features;

import org.softlang.company.*;

/**
 * The degree of polymorphism is increased "after the fact".
 * That is, existing method implementations are provided through a new interface.
 */

public aspect Polymorphism {
	
	declare parents: Company implements Operations;
	declare parents: Department implements Operations;
	declare parents: Employee implements Operations;
	
}
