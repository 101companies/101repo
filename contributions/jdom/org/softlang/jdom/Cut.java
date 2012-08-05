package org.softlang.jdom;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.filter.ElementFilter;

public class Cut {

	public static void cut(Document doc) {
		
		// Iterate over all salary elements
		Iterator<?> iterator = doc.getDescendants(new ElementFilter("salary"));

		// Snapshot these elements before modification
		List<Element> elems = new LinkedList<Element>();
		while (iterator.hasNext())
			elems.add((Element)iterator.next());
		
		// Iterate over salary elements and cut salaries
		for (Element elem : elems) {
			Double salary = Double.valueOf(elem.getText());
			elem.setText(Double.toString(salary/2));
		}
	}
}