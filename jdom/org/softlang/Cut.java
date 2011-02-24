package org.softlang;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.jdom.*;
import org.jdom.filter.ElementFilter;

import static org.softlang.CompanyConstants.*;

public class Cut {

	public static void cut(Document doc) {
		Iterator<?> salaryElementsIt = doc.getDescendants(new ElementFilter(
				"salary", COMPANY_NS));
		List<Element> salaryElements = new LinkedList<Element>();
		while (salaryElementsIt.hasNext())
			salaryElements.add((Element) salaryElementsIt.next());
		for (Element salaryElement : salaryElements)
			salaryElement.setText(Double.toString(Double.valueOf(salaryElement
					.getText()) / 2));
	}
}