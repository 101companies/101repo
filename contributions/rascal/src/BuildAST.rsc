@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Bas Basten - Bas.Basten@cwi.nl (CWI)}
@contributor{Mark Hills - Mark.Hills@cwi.nl (CWI)}
module BuildAST

import String;
import ParseTree;
import Grammar;
import AST;

public Companies buildAST(Tree pt) {
	str toASTString(str inString) = substring(substring(inString,0,size(inString)-1),1);
	
	Companies toAST(S_Companies sc) = companies([ toAST(c) | c <- sc.companies ]);

	Company toAST(S_Company c) {
		if (`company <S_StringLiteral name> { <S_Department* departments> }` := c)
			return company(toASTString("<name>"), [ toAST(d) | d <- departments ])[@at=c@\loc][@nameAt=name@\loc];
		throw "Unrecognized S_Company syntax: <sc>";
	}
	
	Department toAST(S_Department d) {
		if (`department <S_StringLiteral name> { <S_DepartmentElement* elements> }` := d) {
			list[Department] dl = [ ];
			list[Employee] el = [ ];
			for (e <- elements) {
				switch(e) {
					case (S_DepartmentElement) `<S_Department ded>` : dl = dl + toAST(ded);
					case (S_DepartmentElement) `<S_Manager dem>` : el = el + toAST(dem);
					case (S_DepartmentElement) `<S_Employee dee>` : el = el + toAST(dee);
					default : throw "Unrecognized S_DepartmentElement syntax: <e>";
				}	
			}
			return department(toASTString("<name>"), dl, el)[@at=d@\loc][@nameAt=name@\loc];
		}
		throw "Unrecognized S_Department syntax: <d>";
	}
	
	Employee toAST(S_Manager m) {
		if (`manager <S_StringLiteral name> { <S_EmployeeProperty* properties> }` := m)
			return manager(employee(toASTString("<name>"), [ toAST(p) | p <- properties ])[@at=m@\loc][@nameAt=name@\loc])[@at=m@\loc][@nameAt=name@\loc];
		throw "Unrecognized S_Manager syntax: <m>";
	}
	
	Employee toAST(S_Employee e) {
		if (`employee <S_StringLiteral name> { <S_EmployeeProperty* properties> }` := e)
			return employee(toASTString("<name>"), [ toAST(p) | p <- properties ])[@at=e@\loc][@nameAt=name@\loc];	
		throw "Unrecognized S_Employee syntax: <e>";
	}
	
	EmployeeProperty toAST(S_EmployeeProperty ep) {
		if (`<S_Identifier name> <S_Literal val>` := ep) {
			switch(val) {
				case (S_Literal)`<S_StringLiteral slit>` : return strProp("<name>", toASTString("<slit>"))[@at=ep@\loc][@nameAt=name@\loc][@valueAt=val@\loc];
				case (S_Literal)`<S_IntegerLiteral ilit>` : return intProp("<name>", toInt("<ilit>"))[@at=ep@\loc][@nameAt=name@\loc][@valueAt=val@\loc];
				default : throw "Unrecognized S_Literal syntax: <val>"; 
			}
		}
		throw "Unrecognized S_EmployeeProperty syntax: <ep>";
	}
	
	if (start[S_Companies] sc := pt, list[Tree] tl := sc[1])
		return toAST(tl[1]);
	else	
		throw "Invalid model syntax: <pt>";
}