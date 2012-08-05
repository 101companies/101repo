package org.softlang.jdom;

import java.util.Iterator;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.filter.ElementFilter;

public class Total {

	public static double total(Document doc) {

		// Aggregate salaries
		double total = 0;
		
		// Iterate over all salary elements
		Iterator<?> iterator = doc.getDescendants(new ElementFilter("salary"));
		while (iterator.hasNext()) {
			Double salary = Double.valueOf(((Element)iterator.next()).getText());
			total += salary;
		}

		return total;
	}
}