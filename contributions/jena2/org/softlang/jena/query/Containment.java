package org.softlang.jena.query;

import org.softlang.company.CompanyModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.vocabulary.RDFS;

/**
 * 
 * Check that employees and department are not referenced twice.
 *
 */
public class Containment {

	public static boolean checkContainment(CompanyModel c){
		String queryString = 
			"ASK" +
				// check whether any manager is an employee in any other department
				"{?dept1"        + " <" + c.MANAGER   + "> " + "?manager"         + ". " +
				" ?dept2"		 + " <" + c.EMPLOYEES + "> " + "?employees1"      + ". " +
				" ?employees1"   + " <" + RDFS.member + "> " + "?employee1"       + ". " +
				" FILTER (?manager = ?employee1) " +
				
				// check whether any employee occurs more than once
				" ?dept3 "		 + " <" + c.EMPLOYEES + "> " + "?employees2"      + ". " +
				" ?employees2"   + " <" + RDFS.member + "> " + "?employee2"       + ". " +
				" FILTER (?employee1 = ?employee2)" +
				
				// check whether any department occurs more than once
				" ?upperDept1"   + " <" + c.DEPTS     + "> " + "?dept4"           + ". " +
				" ?upperDept2"   + " <" + c.DEPTS     + "> " + "?dept5"           + ". " +
				" FILTER (?dept4 = ?dept5) " +
				"}";
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, c.getModel());
		boolean out = qe.execAsk();
		qe.close();
		return !out;
	}
	
} 