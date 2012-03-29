package org.softlang.jena.query;

import org.softlang.company.CompanyModel;
import com.hp.hpl.jena.query.*;

/**
 * 
 * Total all salaries in a company.
 * 
 */
public class Total {

	public static double total(CompanyModel c){
		String queryString = 
			"SELECT sum(?salary)" +
			"WHERE " +
				"{?e"   + " <" + c.SALARY	+ "> " + "?salary"  + "}";
		
		// We need some "syntax extension" here
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		QueryExecution qe = QueryExecutionFactory.create(query, c.getModel());
		ResultSet rs = qe.execSelect();
		double ttl = rs.next().getLiteral(rs.getResultVars().get(0))
				.getDouble();
		qe.close();
		return ttl;
	}
	
}
