package pkg101;

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
			Element elem = (Element)iterator.next();
			Double salary = Double.valueOf(elem.getText());
			total += salary;
		}

		return total;
	}
}