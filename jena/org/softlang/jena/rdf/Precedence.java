package org.softlang.jena.rdf;

import java.util.LinkedList;
import java.util.List;

import org.softlang.company.CompanyModel;

import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;

/**
 * 
 * Check that salaries increase with rank in hierarchy.
 * 
 */
public class Precedence {

	public static boolean checkPrecedence(CompanyModel c) {

		StmtIterator stmtit = c.getModel().listStatements(
				new SimpleSelector(null, c.DEPTS, (RDFNode) null));

		List<Resource> depts = new LinkedList<Resource>();

		while (stmtit.hasNext()) {
			NodeIterator subDeptsIt = stmtit.next().getBag().iterator();
			while (subDeptsIt.hasNext())
				depts.add(subDeptsIt.next().asResource());
		}
		for (Resource dept : depts) {
			// get manager's salary
			double managerSalary = dept.getProperty(c.MANAGER).getProperty(
					c.SALARY).getDouble();
			NodeIterator employeeIt = dept.getProperty(c.EMPLOYEES).getBag()
					.iterator();
			while (employeeIt.hasNext())
				if (!(employeeIt.next().asResource().getProperty(c.SALARY)
						.getDouble() < managerSalary))
					return false;
		}

		return true;

	}
}
