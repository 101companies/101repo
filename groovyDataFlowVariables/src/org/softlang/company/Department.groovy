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
		Dataflows totals = new Dataflows()
		
		// outsourcing total computation for the dept
		task {
			// retrieving employees' total
			double tmpDept = manager.salary + totals.employees // suspension!?
			subdepts.each() { d ->
				// retrieving subdept's total
				tmpDept += totals.getAt d.name // suspension!?
			}
			totals.dept = tmpDept // binding
		}
		
		// outsourcing total computation for each subdept
		subdepts.each() {d -> 
			task {
				// adding subdept's total to the bean
				totals.putAt d.name, d.total()
			}
		};
		
		// outsourcing total computation for the employees
		task {
			double tmpEmployees = 0
			employees.each { e ->
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