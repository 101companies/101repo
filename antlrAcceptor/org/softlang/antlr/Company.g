grammar Company;

options {
  k = 1;
}

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
  'company' STRING '{' dept* '}' EOF;
  
dept :
  'department' STRING '{' 
    ('manager' employee)
    ('employee' employee)* 
    dept*
  '}';

employee :
  STRING '{'
    'address' STRING
    'salary' FLOAT
  '}';

WS      :   (' '|'\r'? '\n'|'\t')+ {skip();};
STRING  :   '"' (~'"')* '"';
FLOAT   :   ('0'..'9')+ ('.' ('0'..'9')+)?;
