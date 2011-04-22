grammar Company;

options { output=AST; }

tokens { COMPANY; DEPT; MANAGER; PU; EMPLOYEE; }

@header {
package org.softlang.antlr;
}

@lexer::header {
package org.softlang.antlr;
}

@members {

// Throw if any error was emitted
public boolean error = false;

@Override
public void emitErrorMessage(String msg) 
{
  error = true;
  super.emitErrorMessage(msg);
}
}

company :
  'company' STRING '{' dept* '}'
  -> ^(COMPANY STRING dept*)
  ;
  
dept :
  'department' name=STRING '{' 
    manager
    personunit*
    dept*
  '}'
  -> ^(DEPT $name manager personunit* dept*)
  ;
  
manager :
  'manager' employee
  -> ^(MANAGER employee)
  ;
  
personunit :
  'employee' employee
  -> ^(PU employee)
  ; 
  
employee :
  n=STRING '{'
    'address' a=STRING
    'salary' s=FLOAT
  '}'
  -> ^(EMPLOYEE $n $a $s)
  ;

WS      :   (' '|'\r'? '\n'|'\t')+ {skip();};
STRING  :   '"' (~'"')* '"';
FLOAT   :   ('0'..'9')+ ('.' ('0'..'9')+)?;
