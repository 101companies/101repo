package org.softlang.jena.rdf;

import org.softlang.company.CompanyModel;
import java.util.List;
import com.hp.hpl.jena.rdf.model.*;

/**
 * Cut all salaries in half.
 */
public class Cut {

	public static void cut(CompanyModel c) {
		List<Statement> l =
			c.getModel().listStatements(
				new SimpleSelector(
					null, c.SALARY, (RDFNode) null)).toList();
		for (Statement s : l) 
			s.changeLiteralObject(s.getDouble() / 2);
	}
}
