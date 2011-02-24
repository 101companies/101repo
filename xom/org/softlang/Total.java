package org.softlang;

import java.util.HashSet;
import java.util.Set;

import nu.xom.Element;
import nu.xom.Elements;
import static org.softlang.CompanyConstants.*;

public class Total {

	public static Set<Element> collectAllEmployees(Element deptElement) {
		HashSet<Element> employeeElements = new HashSet<Element>();
		employeeElements.add(deptElement.getFirstChildElement("manager",
				COMPANY_NS));
		Elements subunitElements = deptElement.getChildElements("subunit",
				COMPANY_NS);
		for (int i = 0; i < subunitElements.size(); i++) {
			Element suElement = subunitElements.get(i);
			Element puElement = suElement
					.getFirstChildElement("pu", COMPANY_NS);
			if (puElement != null)
				employeeElements.add(puElement);
			else
				employeeElements.addAll(collectAllEmployees(suElement
						.getFirstChildElement("du", COMPANY_NS)));
		}
		return employeeElements;
	}

	public static double total(Element companyElement) {
		double ttl = 0;
		Elements topDeptElements = companyElement.getChildElements("dept",
				COMPANY_NS);
		HashSet<Element> employeeElements = new HashSet<Element>();
		for (int i = 0; i < topDeptElements.size(); i++)
			employeeElements
					.addAll(collectAllEmployees(topDeptElements.get(i)));

		for (Element employeeElement : employeeElements) {
			ttl += Double.valueOf(employeeElement.getFirstChildElement(
					"salary", COMPANY_NS).getValue());
		}
		return ttl;
	}
}
