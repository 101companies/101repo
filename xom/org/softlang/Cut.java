package org.softlang;

import java.util.HashSet;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Text;
import static org.softlang.CompanyConstants.*;

public class Cut {

	public static void cut(Element companyElement) {
		Elements topDeptElements = companyElement.getChildElements("dept",
				COMPANY_NS);

		HashSet<Element> employeeElements = new HashSet<Element>();
		for (int i = 0; i < topDeptElements.size(); i++)
			employeeElements.addAll(Total.collectAllEmployees(topDeptElements
					.get(i)));

		for (Element employeeElement : employeeElements) {
			// get salary Element
			Element oldSalaryElement = employeeElement.getFirstChildElement(
					"salary", COMPANY_NS);
			// get it's value and remove it
			double salary = Double.valueOf(oldSalaryElement.getValue());
			employeeElement.removeChild(oldSalaryElement);
			// set new salary
			Element newSalaryElement = new Element("salary", COMPANY_NS);
			newSalaryElement.appendChild(new Text(Double.toString(salary / 2)));
			employeeElement.appendChild(newSalaryElement);
		}

	}

}
