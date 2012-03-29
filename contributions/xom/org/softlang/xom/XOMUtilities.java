package org.softlang.xom;

import java.util.LinkedList;
import java.util.List;

import nu.xom.Element;
import nu.xom.Elements;

public class XOMUtilities {
	
	public static List<Element> descendants(Element elem, String name) {
		List<Element> list = new LinkedList<Element>();
		descendants(elem, name, list);
		return list;
	}
	
	private static void descendants(Element elem, String name, List<Element> list) {
		if (elem.getLocalName()==name)
			list.add(elem);
		Elements kids = elem.getChildElements();
		for (int i = 0; i < kids.size(); i++)
			descendants(kids.get(i), name, list);
	}
}
