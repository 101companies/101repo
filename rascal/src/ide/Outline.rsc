@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Bas Basten - Bas.Basten@cwi.nl (CWI)}
@contributor{Mark Hills - Mark.Hills@cwi.nl (CWI)}
module ide::Outline

import util::IDE;
import ParseTree;
import String;
import Grammar;

public node buildOutline(Tree pt) {
	str toLabel(str inString) = substring(substring(inString,0,size(inString)-1),1);
	
	node outlineIt(S_Companies sc) = "companies"([ outlineIt(c) | c <- sc.companies ])[@label="Companies"][@\loc=sc@\loc];

	node outlineIt(S_Company c) {
		if (`company <S_StringLiteral name> { <S_Department* departments> }` := c)
			return "company"([ outlineIt(d) | d <- departments ])[@label=toLabel("<name>")][@\loc=c@\loc];
		throw "Unrecognized S_Company syntax: <sc>";
	}
	
	node outlineIt(S_Department d) {
		if (`department <S_StringLiteral name> { <S_DepartmentElement* elements> }` := d) {
			return "department"([outlineIt(e) | ev <- elements, ((S_DepartmentElement)`<S_Department e>` := ev || (S_DepartmentElement)`<S_Manager e>` := ev || (S_DepartmentElement)`<S_Employee e>` := ev)])[@label=toLabel("<name>")][@\loc=d@\loc];
		}
		throw "Unrecognized S_Department syntax: <d>";
	}
	
	node outlineIt(S_Manager m) {
		if (`manager <S_StringLiteral name> { <S_EmployeeProperty* properties> }` := m)
			return "manager"()[@label=toLabel("<name>")][@\loc=m@\loc];
		throw "Unrecognized S_Manager syntax: <m>";
	}
	
	node outlineIt(S_Employee e) {
		if (`employee <S_StringLiteral name> { <S_EmployeeProperty* properties> }` := e)
			return "employee"()[@label=toLabel("<name>")][@\loc=e@\loc];
		throw "Unrecognized S_Employee syntax: <e>";
	}
	
	if (start[S_Companies] sc := pt, list[Tree] tl := sc[1])
		return outlineIt(tl[1]);
	else	
		throw "Invalid model syntax: <pt>";
}