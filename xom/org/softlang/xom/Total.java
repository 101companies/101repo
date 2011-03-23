package org.softlang.xom;

import nu.xom.Element;
import static org.softlang.xom.XOMUtilities.*;

public class Total {
	
	public static double total(Element elem) {
		double total = 0;
		for (Element s : descendants(elem, "salary"))
			total += Double.valueOf(s.getValue());
		return total;
	}
}
