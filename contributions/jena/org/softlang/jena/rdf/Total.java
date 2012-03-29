package org.softlang.jena.rdf;

import org.softlang.company.CompanyModel;
import com.hp.hpl.jena.rdf.model.*;

/**
 * Total all salaries in a company.
 */
public class Total {

	public static double total(CompanyModel c) {
		double total = 0;
		StmtIterator i =
			c.getModel().listStatements(
				new SimpleSelector(
					null, c.SALARY, (RDFNode) null));
		while (i.hasNext()) {
			Statement s = i.next();
			total += s.getDouble();
		}
		return total;
	}
}
