package org.softlang.company;

import groovyx.gpars.dataflow.Dataflows
import groovyx.gpars.dataflow.DataflowVariable
import static groovyx.gpars.dataflow.Dataflow.task


class Company {
	
	String name
	List<Department> depts = new LinkedList<Department>()
	
	double total() {
		// map: DataFlowVariable -> bounded value
		Dataflows totals = new Dataflows()
		
	    // outsourcing total computation for the company
		task {
			double tmpCompany = 0
			for (d in depts)
			    // retrieving dept's total
				tmpCompany += totals.getAt d.name // suspension!?
			totals.company = tmpCompany // binding
		}
		
		// outsourcing total computation for each the department
		for (i in 0..<depts.size) {
			Department d = depts.get i
			task {
				// adding dept's total as dataflow variable to the map
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

