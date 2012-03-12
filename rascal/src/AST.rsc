@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Bas Basten - Bas.Basten@cwi.nl (CWI)}
@contributor{Mark Hills - Mark.Hills@cwi.nl (CWI)}
module AST

anno loc Company@at;
anno loc Department@at;
anno loc Employee@at;
anno loc EmployeeProperty@at;
anno loc Company@nameAt;
anno loc Department@nameAt;
anno loc Employee@nameAt;
anno loc EmployeeProperty@nameAt;
anno loc EmployeeProperty@valueAt;

data Companies 
	= companies(list[Company] comps)
	;

data Company 
	= company(str name, list[Department] deps)
	;

data Department 
	= department(str name, list[Department] deps, list[Employee] empls)
	;

data Employee 
	= employee(str name, list[EmployeeProperty] props)
	;

data Employee 
	= manager(Employee emp)
	;

data EmployeeProperty 
	= intProp(str name, int intVal)
	| strProp(str name, str strVal)
	;
