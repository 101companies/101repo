@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Bas Basten - Bas.Basten@cwi.nl (CWI)}
@contributor{Mark Hills - Mark.Hills@cwi.nl (CWI)}
module Operations

import AST;
import IO;

@doc{Cut the salary of every employee in the company in half}
public Company cut(Company c) {
	return visit (c) {
		case employee(name, [*ep,ip:intProp("salary",salary),*ep2]) => employee(name, [*ep,ip[intVal=salary/2],*ep2])
	}
}

@doc{Total the salaries of all employees}
public int total(Company c) {
	return (0 | it + salary | /employee(name, [*ep,ip:intProp("salary",salary),*ep2]) <- c);
}

@doc{Print the current salary assignments, useful for debugging}
public void printCurrent(Company c) {
	visit (c) {
		case employee(name, [*ep,ip:intProp("salary",salary),*ep2]) :
			println("<name>: $<salary>");
	}
}
