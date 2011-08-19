package org.softlang.company;

import groovyx.gpars.dataflow.Dataflows
import groovyx.gpars.dataflow.DataflowVariable
import static groovyx.gpars.dataflow.Dataflow.task


class Department {
	
	String name
	Employee manager
	List<Department> subdepts = new LinkedList<Department>()
	List<Employee> employees = new LinkedList<Employee>()

	
	double total() {
		// map: DataFlowVariable -> bounded value
		Dataflows totals = new Dataflows()
		
		// outsourcing total computation for the dept
		task {
			// retrieving employees' total
			double tmpDept = manager.salary + totals.employees // suspension!?
			for (d in subdepts)
				// retrieving subdept's total
				tmpDept += totals.getAt d.name // suspension!?
			totals.dept = tmpDept // binding
		}
		
		// outsourcing total computation for each subdept
		for (i in 0..<subdepts.size()) {
			Department d = subdepts.get(i)
			task {
				// adding subdept's total as dataflow variable to the map
				totals.putAt d.name, d.total()
			}
		}
		
		// outsourcing total computation for the employees
		task {
			double tmpEmployees = 0
			for (e in employees) {
				tmpEmployees += e.salary
			}
			totals.employees = tmpEmployees // binding
		}
		
		return totals.dept // suspension!?
	}
	
	void cut() {
		getManager().cut()
		for (s in subdepts)
			s.cut()
		for (e in employees)
			e.cut();
	}	
}