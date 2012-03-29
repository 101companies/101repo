package org.softlang.xom;

import nu.xom.Element;
import nu.xom.Text;
import static org.softlang.xom.XOMUtilities.descendants;

public class Cut {

	public static void cut(Element elem) {
		for (Element s : descendants(elem, "salary")) {
			double value = Double.valueOf(s.getValue());
			value /= 2;
			s.removeChildren();
			s.appendChild(new Text(Double.toString(value)));
		}
	}

}
