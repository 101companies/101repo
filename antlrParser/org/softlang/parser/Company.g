grammar Company;

options {
  k = 1;
}

@header {
package org.softlang.parser;
}

@lexer::header {
package org.softlang.parser;
}

@members {

public double total = 0;

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
  'company' STRING '{' department* '}' EOF;
  
department :
  'department' STRING '{' 
    ('manager' employee)
    ('employee' employee)* 
    department*
  '}';

employee :
  STRING '{'
    'address' STRING
    'salary' s=FLOAT 
    { total += Double.parseDouble($s.text); }
  '}';

WS      :   (' '|'\r'? '\n'|'\t')+ {skip();};
STRING  :   '"' (~'"')* '"';
FLOAT   :   ('0'..'9')+ ('.' ('0'..'9')+)?;
