package org.softlang.jena.rdf;

import org.softlang.company.CompanyModel;
import com.hp.hpl.jena.rdf.model.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Check that employees and department are not referenced twice.
 * 
 */
public class Containment {

	public static boolean checkContainment(CompanyModel c) {

		// get all employee bag statements
		StmtIterator stmtitEmpl = c.getModel().listStatements(
				new SimpleSelector(null, c.EMPLOYEES, (RDFNode) null));

		// get all manager statements
		StmtIterator stmtitMan = c.getModel().listStatements(
				new SimpleSelector(null, c.MANAGER, (RDFNode) null));

		// Collect all employees and managers in a set.
		// Because two resources are java-equal if their URIs are equal,
		// adding will return false, if the manager/employee was already found
		// somewhere else in the company.
		Set<Resource> employeesManagers = new HashSet<Resource>();
		while (stmtitEmpl.hasNext()) {
			NodeIterator employeeIt = stmtitEmpl.next().getBag().iterator();
			while (employeeIt.hasNext()) {
				if (!employeesManagers.add(employeeIt.next().asResource()))
					return false;
			}
		}
		while (stmtitMan.hasNext()) {
			if (!employeesManagers.add(stmtitMan.next().getObject()
					.asResource()))
				return false;
		}
		// employee containment check done.

		// get all department bag statements
		StmtIterator stmtitDept = c.getModel().listStatements(
				new SimpleSelector(null, c.DEPTS, (RDFNode) null));

		// Collect all departments in a set. Same strategy as in employee
		// containment check.
		Set<Resource> depts = new HashSet<Resource>();
		while (stmtitDept.hasNext())
			if (!depts.add(stmtitDept.next().getObject().asResource()))
				return false;

		return true;
	}

}