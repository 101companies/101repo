@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Bas Basten - Bas.Basten@cwi.nl (CWI)}
@contributor{Mark Hills - Mark.Hills@cwi.nl (CWI)}
module Verify

import List;
import Set;
import String;
import Message;
import AST;

/*
From http://101companies.org/index.php/101feature:Company

There are companies, departments, and employees.

Each company has a unique name.
Each company aggregates a possibly empty list of departments.
Each department has a unique name across the company.
Each department must have a manager.
Each department aggregates possibly empty lists of employees and sub-departments.
Each employee has a name.
Employees have additional properties for salary and address.
Each employee serves only in one position in one company.
Managers are employees, too.
All properties (names, addresses, salaries) must be not null.

*/

@doc{Verify a number of correctness conditions on the AST}
public set[Message] verify(Companies cs) {
	set[Message] errors = {};

	// Check 1: Each company has a unique name.
	errors += uniqueCompanyNames(cs);

	// Check 2: Each department has a unique name across the company.
	for (c <- cs.comps) errors += uniqueDepartmentNames(c);
			
	// Check 3: Each department must have a manager.
	for (/Department d <- cs) errors += departmentHasOneManager(d);
		
	// Check 4: Each employee has a name.
	for (/Employee e <- cs) errors += employeeHasName(e);
	
	// Check 5: Employees have additional properties for salary and address.
	for (/Employee e <- cs) errors += employeeHasInfo(e);
	
	// Check 6: Each employee serves only in one position in one company.
	errors += employeeOccursOnce(cs);
	
	// Check 7: All properties (names, addresses, salaries) must be not null.
	errors += propertiesNotNull(cs);
	
	return errors;
}

@doc{Check the condition that each company has a unique company name}
public set[Message] uniqueCompanyNames(Companies cs) {
	set[Message] errors = { };
	set[str] cNames = { };
	top-down visit(cs) {
		case c:company(n,_) :
			if (size(trim(n)) > 0, trim(n) in cNames)
				errors = errors + error("Duplicate company name", c@nameAt);
			else
				cNames += trim(n);
	}
	return errors;
}

@doc{Check the condition that each department has a unique name within a company}
public set[Message] uniqueDepartmentNames(Company c) {
	set[Message] errors = { };
	set[str] dNames = { };
	top-down visit(c) {
		case d:department(n,_,_) :
			if (size(trim(n)) > 0, trim(n) in dNames)
				errors = errors + error("Duplicate department name", d@nameAt);
			else
				dNames += trim(n);
	}
	return errors; 
}

@doc{Check the condition that each department has exactly one manager}
public set[Message] departmentHasOneManager(Department d) {
	set[Message] errors = { };
	managers = [ m | m:manager(_) <- d.empls ];
	if (size(managers) == 0)
		errors = errors + error("One manager must be declared for the department", d@at);
	else if (size(managers) > 1) {
		for ( m <- tail(managers))
			errors = errors + error("Exactly one manager must be declared for the department", m@at);
	}
	return errors; 
}

@doc{Check the condition that each employee has a name}
public set[Message] employeeHasName(Employee e) {
	set[Message] errors = { };
	if (manager(em) := e) return employeeHasName(em);
	if (size(trim(e.name)) == 0)
		errors = errors + error("Employee must have a name", e@nameAt);
	return errors; 
}

@doc{Check the condition that each employee has a salary and address}
public set[Message] employeeHasInfo(Employee e) {
	set[Message] errors = { };
	if (manager(em) := e) return employeeHasInfo(em);
	if (! ([_*,intProp("salary",_),_*] := e.props))
		errors = errors + error("Employee properties must include salary", e@at);
	if (! ([_*,strProp("address",_),_*] := e.props))
		errors = errors + error("Employee properties must include address", e@at);
	return errors; 
}

@doc{Check the condition that each employee appears at most one time in the model}
public set[Message] employeeOccursOnce(Companies cs) {
	set[str] seenBefore = { };
	set[Message] errors = { };
	
	top-down visit(cs) {
		case e:employee(n,_) :
			if (size(trim(n)) > 0, trim(n) in seenBefore) {
				errors = errors + error("Employee may only appear in one position in one company", e@at);
			} else {
				seenBefore += trim(n);
			}
	}
	 
	return errors; 
}

@doc{Check to ensure that the properties are not null.}
public set[Message] propertiesNotNull(Companies cs) {
	set[Message] errors = { };
	
	top-down visit(cs) {
		case c:company(n,_) :
			if (size(trim(n)) == 0)
				errors = errors + error("Company name may not be null", c@nameAt);
		
		case d:department(n,_,_) :
			if (size(trim(n)) == 0)
				errors = errors + error("Department name may not be null", d@nameAt);
		
		// NOTE: The following is handled by the employeeHasName check, and
		// so is commented out here to prevent a duplicate error message.
		//case e:employee(n,_) :
		//	if (size(trim(n)) == 0)
		//		errors = errors + error("Employee name may not be null", e@at);

		case ep:intProp(n,_) :
			if (size(trim(n)) == 0)
				errors = errors + error("Property name may not be null", ep@nameAt);	

		case ep:strProp(n,m) : {
			if (size(trim(n)) == 0)
				errors = errors + error("Property name may not be null", ep@nameAt);	
			if (size(trim(m)) == 0)
				errors = errors + error("Property value may not be null", ep@valueAt);
		}	
	}
	
	return errors;
}