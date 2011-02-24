grammar Company;

@header {
package org.softlang.antlr;
}
@lexer::header {
package org.softlang.antlr;
}

company :
  'company' STRING '{' dept* '}';
  
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
