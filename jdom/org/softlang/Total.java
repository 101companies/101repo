package org.softlang;

import java.util.Iterator;
import org.jdom.*;
import org.jdom.filter.ElementFilter;

import static org.softlang.CompanyConstants.*;

public class Total {

	public static double total(Document doc) {
		double ttl = 0;
		Iterator<?> salaryElementsIt = doc.getDescendants(new ElementFilter(
				"salary", COMPANY_NS));
		while (salaryElementsIt.hasNext())
			ttl += Double.valueOf(((Element) salaryElementsIt.next()).getValue());
		return ttl;
	}

}