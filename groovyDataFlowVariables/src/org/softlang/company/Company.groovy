package org.softlang.company;

import groovyx.gpars.dataflow.Dataflows
import groovyx.gpars.dataflow.DataflowVariable
import static groovyx.gpars.dataflow.Dataflow.task


class Company {
	
	String name
	List<Department> depts = new LinkedList<Department>()
	
	double total() {
		Dataflows totals = new Dataflows()
		
	    // outsourcing total computation for the company
		task {
			double tmpCompany = 0
			depts.each() { d ->
			    // retrieving dept's total
				tmpCompany += totals.getAt d.name // suspension!?
			}
			totals.company = tmpCompany // binding
		}
		
		// outsourcing total computation for each department
		depts.each() { d -> 
			task {
				// adding dept's total to the bean
				totals.putAt d.name, d.total()
			}
		}
		return totals.company// suspension!?
	}
	
	void cut() {
		for (d in depts)
			d.cut()
	}	
}

