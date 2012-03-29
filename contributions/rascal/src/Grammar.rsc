@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Bas Basten - Bas.Basten@cwi.nl (CWI)}
@contributor{Mark Hills - Mark.Hills@cwi.nl (CWI)}
module Grammar

/*
company "meganalysis" {
  department "Research" {
    manager "Craig" {
      address "Redmond"
      salary 123456
    }
    employee "Erik" {
      address "Utrecht"
      salary 12345
    }
    ...
  }
  department "Development" {
    manager "Ray" {
      address "Redmond"
      salary 234567
    }
    department "Dev1" { ... }
    department "Dev2" { ... }
  }
}
*/
start syntax S_Companies = S_Company+ companies;

syntax S_Company
	= @Foldable "company" S_StringLiteral name "{" S_Department* departments "}"
	;

syntax S_Department
	= @Foldable "department" S_StringLiteral name "{" S_DepartmentElement* elements "}"
	;
	
syntax S_DepartmentElement
	= S_Department
	| S_Manager
	| S_Employee
	;

syntax S_Manager
	= @Foldable "manager" S_StringLiteral name "{" S_EmployeeProperty* properties "}"
	;
	
syntax S_Employee
	= @Foldable "employee" S_StringLiteral name "{" S_EmployeeProperty* properties "}"
	; 

syntax S_EmployeeProperty
	= S_Identifier name S_Literal val
	;
	
lexical S_Identifier
	=  @category="Identifier" ([A-Z a-z _] !<< [A-Z _ a-z] [0-9 A-Z _ a-z]* !>> [0-9 A-Z _ a-z]) \ S_Keywords 
	;

keyword S_Keywords
	= "company"
	| "department"
	| "manager"
	| "employee"
	;
	 	
syntax S_Literal
	= S_StringLiteral stringLiteral
	| S_IntegerLiteral integerLiteral
	;

lexical S_StringLiteral
	= @category="Constant" "\"" (![\"])* "\"" 
	;

lexical S_IntegerLiteral
	= @category="Constant" [0-9]+ !>> [0-9]
	;
	
lexical Comment
	= @category="Comment" "/*" (![*] | [*] !>> [/])* "*/" 
	| @category="Comment" "//" ![\n]* !>> [\ \t\r] $ // the restriction helps with parsing speed
	;

lexical Layout 
	= [\t-\n\r\ ]
	| Comment
	;

layout Layouts
	= Layout* !>> [\t-\n \r \ ]
	;
